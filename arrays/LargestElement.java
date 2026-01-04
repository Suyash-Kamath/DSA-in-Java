/*

Largest Element : 3,2,1,5,2

First way is Brute Force Method , sort the array and TC:  Arrays.sort(nums) → O(n log n)


package arrays;
import java.util.Arrays;


public class LargestElement{

    public int largestElement(int []nums){
        Arrays.sort(nums);
        int maximum = nums[nums.length-1];
        return maximum;
    }

    public static void main(String[] args) {
        int []nums = {3,2,1,5,2};

        int result = largestElement(nums);
        System.out.println("Largest Element: "+result);
    }
}

*/


// Optimal Approach, T.C: O(n)
package arrays;






public class LargestElement {

    public static  int largestElement(int[] nums) {
        int size = nums.length;
        int largest = nums[0];

        for (int i = 0; i < size; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 2};


        int result = largestElement(nums);

        System.out.println("Largest Element: " + result);
    }
}
