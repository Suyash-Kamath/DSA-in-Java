public class InversionCount {

    /**
     * Merges two sorted halves of the array while counting inversions.
     *
     * Left Half  : arr[s ... mid]
     * Right Half : arr[mid+1 ... e]
     *
     * An inversion occurs when:
     * arr[i] > arr[j]  where i < j
     *
     * Since both halves are already sorted, whenever an element from the
     * right array is smaller than the current element in the left array,
     * it forms inversions with ALL the remaining elements in the left half.
     */
    static int merge(int[] arr, int s, int e, int mid) {

        // Length of left and right subarrays
        int leftArrLen = mid - s + 1;
        int rightArrLen = e - mid;

        // Temporary arrays to store left and right halves
        int[] leftArr = new int[leftArrLen];
        int[] rightArr = new int[rightArrLen];

        //------------------------------------------------------
        // Copy left half into temporary array
        //------------------------------------------------------
        int k = s;

        for (int i = 0; i < leftArrLen; i++) {
            leftArr[i] = arr[k];
            k++;
        }

        //------------------------------------------------------
        // Copy right half into temporary array
        //------------------------------------------------------
        k = mid + 1;

        for (int i = 0; i < rightArrLen; i++) {
            rightArr[i] = arr[k];
            k++;
        }

        //------------------------------------------------------
        // Merge both arrays while counting inversions
        //------------------------------------------------------

        int i = 0;      // Pointer for left array
        int j = 0;      // Pointer for right array
        k = s;          // Pointer for original array

        int invCount = 0;

        while (i < leftArrLen && j < rightArrLen) {

            // No inversion because left element is already smaller
            if (leftArr[i] <= rightArr[j]) {

                arr[k] = leftArr[i];
                i++;
                k++;

            } else {

                /*
                 * Inversion Found
                 *
                 * Example:
                 * Left  : [5, 6, 8]
                 * Right : [2]
                 *
                 * Since both halves are sorted,
                 * 2 is smaller than 5.
                 *
                 * Therefore,
                 * 2 is also smaller than 6 and 8.
                 *
                 * So total inversions added =
                 * remaining elements in left array
                 *
                 * = leftArrLen - i
                 */

                arr[k] = rightArr[j];
                j++;
                k++;

                invCount += (leftArrLen - i);
            }
        }

        //------------------------------------------------------
        // Copy remaining elements from left array
        //------------------------------------------------------
        while (i < leftArrLen) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        //------------------------------------------------------
        // Copy remaining elements from right array
        //------------------------------------------------------
        while (j < rightArrLen) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }

        return invCount;
    }

    /**
     * Merge Sort recursively divides the array into two halves.
     *
     * Total inversions =
     *      Left inversions
     *    + Right inversions
     *    + Cross inversions (found during merge)
     */
    static int mergeSort(int[] arr, int s, int e) {

        // Base Case:
        // A single element (or empty array) is always sorted
        // and contributes zero inversions.
        if (s >= e) {
            return 0;
        }

        int mid = (s + e) / 2;

        // Count inversions in left half
        int leftInversions = mergeSort(arr, s, mid);

        // Count inversions in right half
        int rightInversions = mergeSort(arr, mid + 1, e);

        // Count inversions between left and right halves
        int intermediateInversions = merge(arr, s, e, mid);

        return leftInversions + rightInversions + intermediateInversions;
    }

    /**
     * Driver function.
     */
    public int inversionCount(int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        return mergeSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {

        int[] arr = {8,3,5,4,7,6,1,2};

        InversionCount obj = new InversionCount();

        int inversions = obj.inversionCount(arr);

        System.out.println("Number of Inversions = " + inversions);

        System.out.print("Sorted Array = ");

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}