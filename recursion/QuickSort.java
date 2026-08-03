import java.util.Arrays;

public class QuickSort {

    static void quickSort(int[] arr, int low, int high) {

        // Base case
        if (low >= high) {
            return;
        }

        // Partition
        int pivotIndex = partition(arr, low, high);

        // Left part
        quickSort(arr, low, pivotIndex - 1);

        // Right part
        quickSort(arr, pivotIndex + 1, high);
    }

    static int partition(int[] arr, int low, int high) {

        // Choose first element as pivot
        int s = low;
        int e = high;

        int pivotElement = arr[s];

        // Count elements <= pivot
        int count = 0;
        for (int i = s + 1; i <= e; i++) {
            if (arr[i] <= pivotElement) {
                count++;
            }
        }

        // Correct position of pivot
        int correctPosition = s + count;

        // Place pivot at its correct position
        int temp = arr[correctPosition];
        arr[correctPosition] = arr[s];
        arr[s] = temp;

        // Rearrange remaining elements
        int i = s;
        int j = e;

        while (i < correctPosition && j > correctPosition) {

            // Move i until wrong element is found
            while (i < correctPosition && arr[i] <= pivotElement) {
                i++;
            }

            // Move j until wrong element is found
            while (j > correctPosition && arr[j] > pivotElement) {
                j--;
            }

            // Swap wrong elements
            if (i < correctPosition && j > correctPosition) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        }

        return correctPosition;
    }

    public static void main(String[] args) {

        int[] arr = {8, 3, 4, 1, 6, 2, 7, 5};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("\nAfter Sorting:");
        System.out.println(Arrays.toString(arr));
    }
}
