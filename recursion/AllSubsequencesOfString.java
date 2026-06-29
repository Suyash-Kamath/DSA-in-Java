import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllSubsequencesOfString {

    static void getAllAubsequences(String s, int index, StringBuilder output, List<String> ans) {
        // Base case
        if (index >= s.length()) {
            ans.add(output.toString());
            return;
        }

        // Include current character
        output.append(s.charAt(index));
        getAllAubsequences(s, index + 1, output, ans);

        // Exclude current character (Backtracking)
        output.deleteCharAt(output.length() - 1);
        getAllAubsequences(s, index + 1, output, ans);
    }

    public List<String> powerSet(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder output = new StringBuilder();

        getAllAubsequences(s, 0, output, ans);

        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {

        AllSubsequencesOfString obj = new AllSubsequencesOfString();

        String str = "abc";

        List<String> result = obj.powerSet(str);

        System.out.println("All Subsequences:");
        for (String subsequence : result) {
            System.out.println("\"" + subsequence + "\"");
        }
    }
}