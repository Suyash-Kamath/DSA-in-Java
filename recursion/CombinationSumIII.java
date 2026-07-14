import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    static void solve(int number,
                      int k,
                      int target,
                      List<List<Integer>> ans,
                      List<Integer> output) {

        // Base Case:
        // We selected exactly k numbers.
        if (output.size() == k) {

            // If target also becomes 0,
            // then we found one valid answer.
            if (target == 0) {
                ans.add(new ArrayList<>(output));
            }

            return;
        }

        // Numbers are only from 1 to 9.
        if (number > 9) {
            return;
        }

        // Target became negative.
        if (target < 0) {
            return;
        }

        // --------------------------------
        // Choice 1 : Take current number
        // --------------------------------

        output.add(number);

        solve(
                number + 1,
                k,
                target - number,
                ans,
                output
        );

        // Backtrack
        output.remove(output.size() - 1);

        // --------------------------------
        // Choice 2 : Skip current number
        // --------------------------------

        solve(
                number + 1,
                k,
                target,
                ans,
                output
        );
    }

    static List<List<Integer>> combinationSumIII(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        solve(1, k, n, ans, output);

        return ans;
    }

    public static void main(String[] args) {

        int k = 3;
        int n = 9;

        List<List<Integer>> ans = combinationSumIII(k, n);

        for (List<Integer> combination : ans) {
            System.out.println(combination);
        }
    }
}
