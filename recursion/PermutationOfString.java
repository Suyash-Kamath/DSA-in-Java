import java.util.ArrayList;
import java.util.Collections;

public class PermutationOfString {

    static void solve(String s, String output, ArrayList<String> ans) {

        // agar input string empty hai
        // means output string me permutation ready hai
        // store it in ans and return

        if (s.isEmpty()) {
            ans.add(output);
            return;
        }

        // har character ko current position pe rakhkar try karo
        // baaki recursion handle karega

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // remaining string after removing current character
            String remString = s.substring(0, i) + s.substring(i + 1);

            // recursion
            solve(remString, output + ch, ans);
        }
    }


    static ArrayList<String> permutation(String s) {

        ArrayList<String> ans = new ArrayList<>();

        solve(s, "", ans);

        // sort permutations lexicographically
        Collections.sort(ans);

        return ans;
    }


    public static void main(String[] args) {

        String s = "abc";

        ArrayList<String> result = permutation(s);

        System.out.println(result);
    }
}
