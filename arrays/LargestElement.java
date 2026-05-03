// import java.util.Arrays;

public class LargestElement {

    static int getLargestElement(int []arr){

        /*
        Brute Force
        // T.C is O(nlogn)
        Arrays.sort(arr);
        int largestElement = arr[arr.length-1];
        */
       int size = arr.length;
        int largest = arr[0];

        for (int i = 0; i < size; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }
       
       

    
    public static void main(String[] args) {

         int[] nums = {3, 2, 1, 5, 2};
         int result = getLargestElement(nums);
         System.out.println("The largest element in an array is: "+result);
    }
}
