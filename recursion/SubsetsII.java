import java.util.*;

public class SubsetsII {

    static void solve(int[] nums, int index, List<Integer> output, List<List<Integer>> ans) {

        // Base case
        if (index >= nums.length) {
            ans.add(new ArrayList<>(output));
            return;
        }


        // Include current element
        output.add(nums[index]);
        solve(nums, index + 1, output, ans);

        // Backtracking
        output.remove(output.size() - 1);


        // Exclude current element
        // Skip duplicates
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }

        solve(nums, index + 1, output, ans);
    }


    static List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> output = new ArrayList<>();

        // Important step
        Arrays.sort(nums);

        solve(nums, 0, output, ans);

        return ans;
    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 2};

        List<List<Integer>> result = subsetsWithDup(nums);

        System.out.println(result);
    }
}
