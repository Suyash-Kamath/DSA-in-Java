/*

Using variable

import java.util.*;


    PROBLEM: Minimum Bracket Reversal

    Given an expression containing only '{' and '}',
    find the minimum number of bracket reversals required
    to make the expression balanced.

    A bracket reversal means:
        '{' -> '}'
        '}' -> '{'

    IMPORTANT:
    We are NOT inserting or deleting brackets.
    We can only reverse the direction of an existing bracket.


    APPROACH:

    Step 1: Check the length.
        If the expression length is odd, return -1.
        Why?
        Every balanced expression must contain an even number
        of opening and closing brackets combined.

    Step 2: Count unmatched brackets using two counters.

        open  -> number of unmatched opening '{' brackets
        close -> number of unmatched closing '}' brackets

        When we encounter '{':
            If there is an unmatched '}' available, we cannot
            match it with this '{' because the closing bracket
            appeared earlier in the expression.

            Otherwise, increase open.

        When we encounter '}':
            If there is an unmatched '{', match it with this
            closing bracket by decreasing open.

            Otherwise, increase close.

        NOTE:
        The simpler and correct implementation below uses a
        different but equivalent counting strategy:
        count unmatched opening brackets as we traverse.
        A closing bracket cancels an opening bracket whenever
        one is available; otherwise, it is counted as unmatched.

    Step 3: Calculate reversals.

        After cancellation, only unmatched brackets remain.

        Example 1:
            "{{"
            open = 2, close = 0
            Reversals = (2 + 1) / 2 + (0 + 1) / 2
                      = 1

        Example 2:
            "}}"
            open = 0, close = 2
            Reversals = (0 + 1) / 2 + (2 + 1) / 2
                      = 1

        Example 3:
            "}}{{"
            open = 2, close = 2
            Reversals = (2 + 1) / 2 + (2 + 1) / 2
                      = 2

        GENERAL FORMULA:

            (open + 1) / 2 + (close + 1) / 2

        Java performs integer division here, so the fractional
        part is discarded.
*/

public class MinimumBracketReversal {

    public static int countReversals(String str) {

        // STEP 1:
        // An odd-length expression can never be balanced.
        // Every opening bracket needs a corresponding closing
        // bracket, so the total number of brackets must be even.
        if (str.length() % 2 == 1) {
            return -1;
        }

        // open:
        // Counts opening '{' brackets that have not yet been
        // matched with a closing '}' bracket.
        int open = 0;

        // close:
        // Counts closing '}' brackets that appeared without
        // an available opening '{' bracket before them.
        int close = 0;

        // STEP 2:
        // Traverse the expression from left to right.
        // We use counters instead of a stack because we only
        // need the number of unmatched brackets, not their
        // actual positions or values.
        for (char ch : str.toCharArray()) {

            // CASE 1: Current bracket is '{'
            if (ch == '{') {

                // This opening bracket is unmatched for now.
                // A future '}' may cancel it out.
                open++;

            }

            // CASE 2: Current bracket is '}'
            else if (ch == '}') {

                // If an unmatched opening bracket exists,
                // this closing bracket forms a valid "{}" pair.
                if (open > 0) {

                    // Cancel the pair.
                    // One previously unmatched '{' is now matched.
                    open--;

                } else {

                    // No opening bracket is available to match
                    // this closing bracket.
                    // Therefore, this '}' remains unmatched.
                    close++;
                }
            }
        }

        /*
            STEP 3: Calculate the minimum reversals.

            At this point:
                open  = unmatched '{' brackets
                close = unmatched '}' brackets

            All valid "{}" pairs have already been cancelled.

            CASE A: Even number of unmatched brackets

                "{{" -> reverse one bracket -> "}{" 
                "}}" -> reverse one bracket -> "}{" 

                Each pair of identical unmatched brackets
                requires one reversal.

                Reversals = open / 2 + close / 2

            CASE B: Odd number of unmatched brackets

                Since the original expression has even length,
                open and close must have the same parity.
                So if one is odd, both are odd.

                Leave one unmatched '{' and one unmatched '}'
                for the final combination. These require two
                reversals to become a valid pair.

                Reversals =
                    (open - 1) / 2
                    + (close - 1) / 2
                    + 2

            SIMPLIFIED FORMULA FOR BOTH CASES:

                (open + 1) / 2 + (close + 1) / 2
        */

        int openingReversals = (open + 1) / 2;
        int closingReversals = (close + 1) / 2;

        // Add the reversals needed for both unmatched bracket types.
        return openingReversals + closingReversals;
    }

    public static void main(String[] args) {

        // Test cases:
        // Each expression demonstrates a different situation.
        String[] testCases = {
            "{{}}",    // Already balanced -> 0
            "{{",      // Two unmatched openings -> 1
            "}}",      // Two unmatched closings -> 1
            "}}{{",    // Two unmatched closings + two openings -> 2
            "}{{}",    // Unmatched brackets remain -> 2
            "{{{{",    // Four unmatched openings -> 2
            "{",       // Odd length -> -1
            "}}{{}}{{" // Even length, unbalanced expression
        };

        // Run every test case and print its answer.
        for (String expression : testCases) {

            int result = countReversals(expression);

            System.out.println(
                "Expression: " + expression
                + " | Minimum reversals: " + result
            );
        }
    }
}


*/
import java.util.*;

public class MinimumBracketReversal {

    public static int countReversals(String str) {

        /*
         APPROACH:

         Step 1: If the length of the expression is odd,
                 return -1 because it is impossible to balance it.

         Step 2: Use a stack to remove all valid bracket pairs.
                 '{}' is a valid pair, so both brackets cancel out.

         Step 3: After cancellation, only unmatched brackets
                 remain in the stack.

         Step 4: Count the remaining opening '{' and closing '}'.

         Step 5: Calculate the minimum reversals using the formula.

         Example:
         Expression = "}}}}{{{{"

         After removing valid pairs:
         No valid pairs exist, so all brackets remain unmatched.

         Reversals:
         '}}' -> reverse one closing bracket to opening -> '{}'
         '{{' -> reverse one opening bracket to closing -> '{}'

         Total reversals = 2 for "}}{{" and, in general,
         calculate separately for the remaining opening and closing
         brackets using the formula below.
        */

        // Step 1: Odd-length expressions can never be balanced.
        // Every valid balanced expression must contain an even
        // number of brackets.
        if (str.length() % 2 == 1) {
            return -1;
        }

        // Deque is being used as a stack.
        // push() inserts at the top, peek() checks the top,
        // and pop() removes the top element.
        Deque<Character> st = new ArrayDeque<>();

        // Step 2: Remove all valid bracket pairs.
        // If the current character is '}' and the stack's top
        // is '{', they form a valid "{}" pair and cancel out.
        //
        // Otherwise, push the current bracket into the stack.
        // This works because we only need to match an opening
        // bracket with a closing bracket that comes after it.
        for (char ch : str.toCharArray()) {

            // Valid pair found: "{}"
            if (ch == '}' && !st.isEmpty() && st.peek() == '{') {
                st.pop(); // Remove the unmatched '{'
            } else {
                // No valid pair can be formed right now.
                // Keep this bracket for further processing.
                st.push(ch);
            }
        }

        /*
         Step 3: Count the unmatched brackets left in the stack.

         After cancellation, no valid "{}" pair remains.

         The remaining brackets will effectively consist of:
         - Opening brackets: "{{{{"
         - Closing brackets: "}}}}"

         Their order in the stack does not matter anymore,
         because we only need their counts.
        */

        int open = 0;
        int close = 0;

        while (!st.isEmpty()) {

            // pop() removes the top bracket from the stack.
            if (st.pop() == '{') {
                open++;  // Count unmatched opening brackets
            } else {
                close++; // Count unmatched closing brackets
            }
        }

        /*
         Step 4: Calculate minimum reversals.

         Case 1: Even number of opening and closing brackets.

         Example:
         "{{" -> reverse one '{' -> "}{"
         "}}" -> reverse one '}' -> "}{"

         Reversals = open/2 + close/2

         Case 2: Odd number of opening and closing brackets.

         Since the total length is even, if one count is odd,
         the other count must also be odd.

         Example:
         "}}{" -> impossible as a whole expression because
         its length is odd. For an even-length expression,
         the unmatched counts have the same parity.

         For odd counts, leave one opening and one closing
         bracket for the final pair. These two brackets need
         2 reversals to become a valid pair.

         Reversals =
         (open - 1)/2 + (close - 1)/2 + 2

         Simplified formula for BOTH cases:

         Minimum reversals =
         (open + 1)/2 + (close + 1)/2

         Integer division in Java automatically rounds down,
         which makes this formula work for even and odd counts.
        */

        return (open + 1) / 2 + (close + 1) / 2;
    }

    public static void main(String[] args) {

        // Test different expressions, including balanced,
        // unbalanced, and impossible expressions.
        String[] testCases = {
            "{{}}",
            "{{",
            "}}",
            "}{{}",
            "{{{{",
            "}}{{",
            "}}{{}}{{",
            "{"
        };

        for (String str : testCases) {
            System.out.println(
                "Expression: " + str
                + " -> Minimum reversals: " + countReversals(str)
            );
        }
    }
}
