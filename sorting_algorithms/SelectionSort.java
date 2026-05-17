// “Find the smallest element and place it at the correct position.”
// OR:

// “Select the correct element for each position.”

public class SelectionSort {
// T.C is O(n^2)
    static void selectionSort(int []arr){
        int n = arr.length;
        int minIndex =0;
        for(int i=0;i<n-1;i++){
            minIndex =i;
            for(int j =i+1;j<n;j++){
                if(arr[minIndex]>arr[j]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
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
        selectionSort(arr);
        System.out.println("Array after sorting");
        printArr(arr);
    }
}
