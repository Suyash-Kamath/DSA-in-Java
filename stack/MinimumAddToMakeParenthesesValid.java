/*

Without using Stack , using normal var


public class MinimumAddToMakeParenthesesValid {

    public static int minAddToMakeValid(String s) {

        // Number of unmatched opening brackets '('
        int open = 0;

        // Number of opening brackets '(' we need to add
        int addition = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                // Opening bracket found.
                // It needs a matching closing bracket ')'.
                open++;

            } else if (ch == ')') {

                // Closing bracket found.
                if (open > 0) {

                    // An unmatched '(' exists.
                    // Match it with this ')'.
                    open--;

                } else {

                    // No unmatched '(' is available.
                    // We must add an extra '('.
                    addition++;
                }

            } else {

                throw new IllegalArgumentException(
                    "Input must contain only '(' and ')'"
                );
            }
        }

        // addition = missing opening brackets '('
        // open     = unmatched opening brackets '('
        //            that need closing brackets ')'
        int finalAns = addition + open;

        return finalAns;
    }

    public static void main(String[] args) {

        System.out.println(minAddToMakeValid("())"));    // 1
        System.out.println(minAddToMakeValid("((("));    // 3
        System.out.println(minAddToMakeValid("()"));     // 0
        System.out.println(minAddToMakeValid("()))((")); // 4
        System.out.println(minAddToMakeValid("())(()")); // 2
        System.out.println(minAddToMakeValid(""));       // 0
    }
}

*/

// t.c and s.c is O(N)
import java.util.*;

public class MinimumAddToMakeParenthesesValid {

    public static int minAddToMakeValid(String s) {

        // Stores the number of extra ')' brackets we need to add
        int addition = 0;

        // Stack stores unmatched opening brackets '('
        Deque<Character> st = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                // Opening bracket found.
                // Push it because it needs a matching ')'.
                st.push(ch);

            } else if (ch == ')') {

                // Closing bracket found.
                // Check whether an unmatched '(' exists.

                if (st.isEmpty()) {

                    // No opening bracket available to match this ')'.
                    // We must add one '(' before it.
                    addition++;

                } else {

                    // An unmatched '(' exists.
                    // Match it with the current ')'.
                    st.pop();
                }

            } else {

                // Reject characters other than '(' and ')'.
                throw new IllegalArgumentException(
                    "Input must contain only '(' and ')'"
                );
            }
        }

        /*
         * At the end:
         *
         * addition = number of '(' brackets we must add
         * st.size() = number of unmatched '(' brackets
         *             that need matching ')' brackets
         *
         * Therefore:
         * Minimum additions = addition + st.size()
         */

        int finalAns = addition + st.size();

        return finalAns;
    }

    public static void main(String[] args) {

        System.out.println(minAddToMakeValid("())"));    // 1
        System.out.println(minAddToMakeValid("((("));    // 3
        System.out.println(minAddToMakeValid("()"));     // 0
        System.out.println(minAddToMakeValid("()))((")); // 4
        System.out.println(minAddToMakeValid("())(()")); // 2
        System.out.println(minAddToMakeValid(""));       // 0
    }
}
