import java.util.*;

public class PhoneKeypad {

    static void solve(String digits, int index, String[] mapping,
                      List<String> result, StringBuilder output) {

        // Base Case
        // Jaise hi index input string ke bahar chala jaayega,
        // iska matlab output string complete ban chuki hai.
        // Ab ise result list ke andar store kar do.

        if (index >= digits.length()) {
            result.add(output.toString());
            return;
        }

        // 1 case main solve karta hu,
        // baaki saare cases recursion automatically handle karega.

        int value = digits.charAt(index) - '0';

        // Current digit ke corresponding characters nikaal lo.
        String mappedString = mapping[value];

        // Example:
        // value = 5
        // mappedString = "jkl"

        // Ab current block par mapped string ka har character try karenge,
        // aur baaki combinations recursion generate karega.

        for (int i = 0; i < mappedString.length(); i++) {

            // Current character choose karo.
            output.append(mappedString.charAt(i));

            // Remaining input ke liye recursion call.
            solve(digits, index + 1, mapping, result, output);

            // Backtracking (Undo)
            // Jo character abhi add kiya tha usse hata do,
            // taaki next iteration me doosra character try kar sake.
            output.deleteCharAt(output.length() - 1);
        }
    }

    static List<String> letterCombinations(String digits) {

        String[] mapping = {
                "",     // 0
                "",     // 1
                "abc",  // 2
                "def",  // 3
                "ghi",  // 4
                "jkl",  // 5
                "mno",  // 6
                "pqrs", // 7
                "tuv",  // 8
                "wxyz"  // 9
        };

        List<String> result = new ArrayList<>();

        // Edge Case
        // Agar input empty hai to koi combination possible nahi hoga.
        if (digits == null || digits.length() == 0) {
            return result;
        }

        int index = 0;

        StringBuilder output = new StringBuilder();

        solve(digits, index, mapping, result, output);

        return result;
    }

    public static void main(String[] args) {

        String digits = "23";

        System.out.println(letterCombinations(digits));
    }
}
