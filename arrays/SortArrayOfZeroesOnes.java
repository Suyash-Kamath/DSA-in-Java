public class SortArrayOfZeroesOnes {
    
    static int[] sortArray(int[] arr) {
        // T.C is O(N/2) and S.C is O(1)
        int n = arr.length;
        int i = 0;
        int j = n - 1;

        while (i < j) {
            // swap when left is 1 and right is 0
            if (arr[i] == 1 && arr[j] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }

            // move i forward if already correct
            if (arr[i] == 0) {
                i++;
            }

            // move j backward if already correct
            if (arr[j] == 1) {
                j--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {1, 0, 0, 1, 0, 1, 1};
        System.out.println("Sorted array: ");
        
        int ans[] = sortArray(arr);
        for (int k : ans) {
            System.out.print(k + " ");
        }
    }
}