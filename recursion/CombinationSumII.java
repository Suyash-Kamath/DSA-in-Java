import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    static void solve(int[] candidates,
                      int target,
                      int index,
                      List<List<Integer>> ans,
                      List<Integer> output) {

        // Base Case 1:
        // Target becomes 0 => current output list is one valid answer.
        if (target == 0) {
            ans.add(new ArrayList<>(output));
            return;
        }

        // Base Case 2:
        // No elements left.
        if (index >= candidates.length) {
            return;
        }

        // Base Case 3:
        // Target became negative.
        if (target < 0) {
            return;
        }

        // ------------------------------------------
        // Choice 1 : Include current element
        // ------------------------------------------

        output.add(candidates[index]);

        // Combination Sum II:
        // Each element can be used ONLY ONCE.
        // Therefore move to next index.
        solve(
                candidates,
                target - candidates[index],
                index + 1,
                ans,
                output
        );

        // Backtrack
        output.remove(output.size() - 1);

        // ------------------------------------------
        // Choice 2 : Exclude current element
        // ------------------------------------------

        // Skip all duplicate values
        int nextIndex = index + 1;

        while (nextIndex < candidates.length &&
               candidates[nextIndex] == candidates[index]) {
            nextIndex++;
        }

        solve(
                candidates,
                target,
                nextIndex,
                ans,
                output
        );
    }

    static List<List<Integer>> combinationSumII(int[] candidates, int target) {

        // Sorting is mandatory for duplicate skipping.
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        solve(candidates, target, 0, ans, output);

        return ans;
    }

    public static void main(String[] args) {

        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;

        List<List<Integer>> ans = combinationSumII(candidates, target);

        System.out.println("All Possible Combinations:");

        for (List<Integer> combination : ans) {
            System.out.println(combination);
        }
    }
}
