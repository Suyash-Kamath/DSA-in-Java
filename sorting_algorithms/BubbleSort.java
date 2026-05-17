// “Keep comparing adjacent elements and push bigger elements toward the end.”
// “Let the largest element bubble up to its correct position.”

// That’s why it is called Bubble Sort.

// Large elements slowly rise like bubbles in water.

public class BubbleSort {
// T.C is O(n^2)

    static void bubbleSort(int []arr){
        int n = arr.length;

        for(int round =0;round<n-1;round++){

            for(int i=0;i<n-1-round;i++){
                if(arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
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
        bubbleSort(arr);
        System.out.println("Array after sorting");
        printArr(arr);
    }
}
