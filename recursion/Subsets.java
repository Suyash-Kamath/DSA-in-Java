import java.util.*;

public class Subsets {

    static void solve(int[] nums, int index, List<Integer> output, List<List<Integer>> ans) {

        // Base case
        if (index >= nums.length) {

            // Subsequence ready
            // Store a copy because output will change during backtracking
            ans.add(new ArrayList<>(output));
            return;
        }

        int currValue = nums[index];

        // Include current element
        output.add(currValue);
        solve(nums, index + 1, output, ans);

        // Backtracking step
        output.remove(output.size() - 1);

        // Exclude current element
        solve(nums, index + 1, output, ans);
    }


    static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> output = new ArrayList<>();

        int index = 0;

        solve(nums, index, output, ans);

        return ans;
    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        List<List<Integer>> result = subsets(nums);

        System.out.println(result);
    }
}
