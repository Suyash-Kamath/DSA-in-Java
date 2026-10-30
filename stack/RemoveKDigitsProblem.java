
import java.util.*;

public class RemoveKDigitsProblem {

    /*
    Approach: Monotonic Increasing Stack

    1. Traverse every digit in the input string.
    2. If the current digit is smaller than the stack's top,
       remove the previous digit because it would make
       the resulting number larger.
    3. Continue removing while k > 0.
    4. Push the current digit into the stack.
    5. If k removals are still pending, remove digits
       from the end (top of the stack).
    6. Build the answer by popping elements from the stack.
    7. Reverse the answer because the stack stores digits
       in reverse order.
    8. Remove leading zeroes.
    9. If the result is empty, return "0".
    */

    public static String removeKdigits(String num, int k) {

        Deque<Character> st = new ArrayDeque<>();

        // Step 1: Apply monotonic increasing stack pattern
        for (char ch : num.toCharArray()) {

            while (k > 0 && !st.isEmpty() && st.peek() > ch) {
                st.pop();
                k--;
            }

            st.push(ch);
        }

        // Step 2: Handle pending removals
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        // Step 3: Build answer from stack
        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        // Step 4: Reverse the answer
        ans.reverse();

        // Step 5: Remove leading zeroes
        int index = 0;

        while (index < ans.length() && ans.charAt(index) == '0') {
            index++;
        }

        // Step 6: Extract final result
        String result = ans.substring(index);

        // Step 7: Handle empty result
        if (result.length() == 0) {
            return "0";
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(removeKdigits("1432219", 3)); // 1219
        System.out.println(removeKdigits("10200", 1));   // 200
        System.out.println(removeKdigits("10", 2));      // 0
        System.out.println(removeKdigits("123456", 3));  // 123
    }
}
