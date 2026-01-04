// Brute Force Method

/*

Sort the array , pick the last element as largest  and compare from last
It is because it can contain duplicates too.


package arrays;

import java.util.Arrays;

public class SecondLargestElement{

    public static int secondLargestElement(int []arr){
        int size = arr.length;

        if(size<2){
            return -1;
        }
        Arrays.sort(arr);

        int largest = arr[size-1];


        for (int i = size-2;i>=0;i--){
            if(arr[i]!=largest){
                return arr[i];
            }
        }
        return -1;

    }

    public static void main(String []args){
        int []arr = {1,2,4,6,7,5};
        System.out.println("Second Largest Element: "+secondLargestElement(arr));
    }
}

*/

// Better Solution

/*

[1,2,4,6,7,5]

 First find the largest element and then declare one variable and compare it with others too

package arrays;

public class SecondLargestElement {

    public static int secondLargestElement(int []nums){
        int size = nums.length;
        int largest = Integer.MIN_VALUE;
        for(int i=0;i<size;i++){
            if(nums[i]>largest){
                largest = nums[i];
            }
        }


        int secondLargest =Integer.MIN_VALUE;
        for(int i=0;i<size;i++){
            if(nums[i]!=largest && nums[i]>secondLargest){
                secondLargest = nums[i];
            }
        }
        return secondLargest;
    }

    public static void main(String []args){
        int []nums = {1,2,4,6,7,5};
        System.out.println("Second Largest Element: "+secondLargestElement(nums));
    }
}
*/




// Optimal Method

/*

Do it in one pass , but how to do , if you make the next number as largest then the prev number should be secondLargest

* */



package arrays;

public class SecondLargestElement{

    public static int secondLargestElement(int []nums){
        int size = nums.length;
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int i=0;i<size;i++){
            if(nums[i]>largest){
                secondLargest = largest;
                largest = nums[i];
            }
            else if(nums[i]<largest && nums[i]>secondLargest){
                secondLargest = nums[i];
            }
        }
        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
    }
    // 2,1,4,5,7,6
    public static void main(String []args){
        int []nums = {6,2,4,5,7,3};
        System.out.println("Second Largest Element: "+secondLargestElement(nums));
    }
}