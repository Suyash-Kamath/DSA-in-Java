public class MergeSort {

    static void merge(int[] arr, int s, int e, int mid) {

        // We cannot perform merge in-place here,
        // otherwise we will overwrite elements before comparing them.

        int leftArrLen = mid - s + 1;
        int rightArrLen = e - mid;

        int leftArr[] = new int[leftArrLen];
        int rightArr[] = new int[rightArrLen];

        // Copy the left half of the original array into leftArr.
        // Range: s -> mid

        // Copy the right half of the original array into rightArr.
        // Range: mid + 1 -> e

        int k = s;

        for (int i = 0; i < leftArrLen; i++) {
            leftArr[i] = arr[k];
            k++;
        }

        k = mid + 1;

        for (int j = 0; j < rightArrLen; j++) {
            rightArr[j] = arr[k];
            k++;
        }

        // Merge both sorted arrays back into the original array.

        int i = 0;
        int j = 0;
        k = s;

        while (i < leftArrLen && j < rightArrLen) {

            if (leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
                k++;
            } else {
                arr[k] = rightArr[j];
                j++;
                k++;
            }
        }

        // If the left array is completely consumed but
        // the right array still has elements remaining,
        // copy all remaining elements into the original array.

        while (j < rightArrLen) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }

        // If the right array is completely consumed but
        // the left array still has elements remaining,
        // copy all remaining elements into the original array.

        while (i < leftArrLen) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
    }

    static void mergeSort(int arr[], int l, int r) {

        // Base case

        int start = l;
        int end = r;

        if (start >= end) {
            // Invalid range or only one element left.
            return;
        }

        // Divide the array into two equal halves.

        int mid = (start + end) / 2;

        // Recursively sort the left half.

        mergeSort(arr, start, mid);

        // Recursively sort the right half.

        mergeSort(arr, mid + 1, end);

        // Merge both sorted halves into a single sorted array.

        merge(arr, start, end, mid);
    }

    public static void main(String[] args) {

        int[] arr = {8, 3, 5, 4, 7, 6, 1, 2};

        mergeSort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}