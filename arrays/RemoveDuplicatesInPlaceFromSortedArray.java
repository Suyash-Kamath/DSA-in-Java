// Brute Force

/*

Using TreeSet to remove duplicates + keep sorted order
What is TreeSet in Java?

TreeSet is a collection class in Java that:

 Automatically

Removes duplicates

Stores elements in sorted order

Maintains order at all times

Time Complexity is
1️⃣ Inserting into TreeSet

TreeSet is implemented using a Red-Black Tree

Each add() operation costs O(log n)

Loop runs n times:

n × O(log n) = O(n log n)


package arrays;


import java.util.TreeSet;

public class RemoveDuplicatesInPlaceFromSortedArray {

    public static int removeDuplicatesInPlaceSortedArray(int []nums){
        TreeSet<Integer> set = new TreeSet<>();
        for(int i =0 ;i<nums.length;i++){
            set.add(nums[i]);
        }
        int index =0;
        for(int value:set){
            nums[index]=value;
            index++;
        }
        return index;
    }
    public static void main(String []args){
        int []nums = {1,1,2,2,2,3,3};
        int result = removeDuplicatesInPlaceSortedArray(nums);
        System.out.println("Unique Element in Arrays: "+result);
    }
}

 */


// Good solution

//1,1,2,2,2,2,3,3,3

package arrays;

public class RemoveDuplicatesInPlaceFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        // Edge case: empty array
        if (nums.length == 0) return 0;

        int index = 0; // points to last unique element

        // Start from second element
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }
        // Number of unique elements
        return index + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 3};

        int result = removeDuplicates(nums);

        System.out.println("Number of unique elements: " + result);

        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < result; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
