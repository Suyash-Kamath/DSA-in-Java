/*
Index Marking Approach based problem 
*/

import java.util.ArrayList;
import java.util.List;

public class MissingElementsFromArrayWithDuplicates {

    static List<Integer> findDisappearedNumber(int[] nums) {
        // T.C is O(n) and S.C is O(1) for auxillary becuase output toh store karna padega naa , see , the return type , but yeah algorithm ke time me we did not use any extra space , so O(1) is the Space Complexity
        List<Integer> ans = new ArrayList<>();

        // Marking
        for (int index = 0; index < nums.length; index++) {
            int value = Math.abs(nums[index]);
            int position = value - 1;

            if (nums[position] > 0) {
                nums[position] = -nums[position];
            }
        }

        // Find positive indexes
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        List<Integer> result = findDisappearedNumber(nums);

        System.out.println(result);
    }
}