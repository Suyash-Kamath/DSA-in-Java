import java.util.ArrayList;
import java.util.List;

public class CombinationSumI {

    static void solve(int[] candidates,
                      int target,
                      int index,
                      List<List<Integer>> ans,
                      List<Integer> output) {

        // Base Case 1:
        // Target becomes 0 => current output list is one valid answer.
        // Store a COPY of output in ans.
        if (target == 0) {
            ans.add(new ArrayList<>(output));
            return;
        }

        // Base Case 2:
        // We have exhausted all candidates.
        if (index >= candidates.length) {
            return;
        }

        // Base Case 3:
        // Target went below 0, meaning this path cannot form a valid answer.
        if (target < 0) {
            return;
        }

        // ------------------------------------------------
        // At every index we have 2 choices:
        //
        // 1. Include current candidate
        // 2. Exclude current candidate
        // ------------------------------------------------

        // Choice 1 : Include current element

        output.add(candidates[index]);

        // Since Combination Sum I allows using the same element
        // multiple times, we stay at the SAME index.
        //
        // Example:
        // candidates = [2,3,6,7]
        // target = 7
        //
        // If we pick 2 once, we should still be allowed
        // to pick 2 again.
        solve(
                candidates,
                target - candidates[index],
                index,
                ans,
                output
        );

        // Backtracking Step
        //
        // Remove the element we added before exploring
        // the next decision.
        output.remove(output.size() - 1);

        // Choice 2 : Exclude current element
        //
        // Move to the next index because we are deciding
        // not to use the current candidate anymore.
        solve(
                candidates,
                target,
                index + 1,
                ans,
                output
        );
    }

    static List<List<Integer>> combinationSumI(int[] candidates, int target) {

        // Stores all valid combinations.
        List<List<Integer>> ans = new ArrayList<>();

        // Stores the current path / combination being built.
        List<Integer> output = new ArrayList<>();

        int index = 0;

        solve(candidates, target, index, ans, output);

        return ans;
    }

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> ans = combinationSumI(candidates, target);

        System.out.println("All Possible Combinations:");

        for (List<Integer> combination : ans) {
            System.out.println(combination);
        }
    }
}

