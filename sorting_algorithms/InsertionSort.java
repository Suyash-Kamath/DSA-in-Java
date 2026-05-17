/*

Insertion Sort says:

“Take one element and insert it into its correct position in the already sorted part.”

OR more intuitively:

“Grow a sorted portion one element at a time.”

*/

public class InsertionSort {
// T.C is O(n^2)

    static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {

            int currentValue = arr[i];
            int previous = i - 1;

            while (previous >= 0 && currentValue < arr[previous]) {
                arr[previous + 1] = arr[previous];
                previous--;
            }

            arr[previous + 1] = currentValue;
        }
    }
    static void printArr(int []arr){
        int n=arr.length;

        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
         int []arr = {5,1,4,2,8};
        System.out.println("Array before sorting");
        printArr(arr);
        insertionSort(arr);
        System.out.println("Array after sorting");
        printArr(arr);
    }
}
