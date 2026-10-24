
// import java.util.*;

// public class LongestValidParentheses {

//     public static int longestValidParentheses(String s) {

//         /*
//          * APPROACH: STACK OF INDICES
//          *
//          * Goal:
//          * Find the length of the longest valid parentheses substring.
//          *
//          * Example:
//          * Input:  "(()"
//          * Output: 2
//          *
//          * Input:  ")()())"
//          * Output: 4
//          *
//          * Why store indices instead of characters?
//          * We need the positions of the brackets to calculate
//          * the length of a valid substring.
//          *
//          * Why push -1 initially?
//          * -1 acts as a base index / left boundary.
//          * It helps calculate the length when a valid substring
//          * starts from index 0.
//          */

//         Deque<Integer> st = new ArrayDeque<>();

//         // Initial base index: there is no character before index 0.
//         st.push(-1);

//         int maxLen = 0;

//         for (int i = 0; i < s.length(); i++) {

//             char ch = s.charAt(i);

//             // CASE 1: Opening bracket
//             if (ch == '(') {

//                 // Store the index of the opening bracket.
//                 st.push(i);

//             } else {

//                 /*
//                  * CASE 2: Closing bracket ')'
//                  *
//                  * Try to match this closing bracket with an
//                  * unmatched opening bracket by popping the stack.
//                  */

//                 st.pop();

//                 /*
//                  * CASE 2A: Stack becomes empty
//                  *
//                  * There is no valid opening bracket available
//                  * to match the current closing bracket.
//                  *
//                  * Therefore, the current index becomes the new
//                  * invalid boundary.
//                  *
//                  * Any valid substring found after this boundary
//                  * will be measured relative to this index.
//                  */

//                 if (st.isEmpty()) {

//                     st.push(i);

//                 } else {

//                     /*
//                      * CASE 2B: A valid substring can be measured
//                      *
//                      * The stack top represents the index immediately
//                      * before the current valid suffix.
//                      *
//                      * Current valid length = current index - top index.
//                      *
//                      * Example:
//                      * s = "()"
//                      * i = 1
//                      * stack top = -1
//                      * length = 1 - (-1) = 2
//                      */

//                     int currLen = i - st.peek();

//                     // Keep track of the maximum valid length.
//                     maxLen = Math.max(maxLen, currLen);
//                 }
//             }
//         }

//         return maxLen;
//     }

//     public static void main(String[] args) {

//         System.out.println(longestValidParentheses("(()"));     // 2
//         System.out.println(longestValidParentheses(")()())"));  // 4
//         System.out.println(longestValidParentheses(""));        // 0
//         System.out.println(longestValidParentheses("()"));      // 2
//         System.out.println(longestValidParentheses("()(()"));   // 2
//         System.out.println(longestValidParentheses("()(())"));  // 6
//         System.out.println(longestValidParentheses("))))"));    // 0
//     }
// }








public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {

        /*
         * ============================================================
         * PROBLEM: LONGEST VALID PARENTHESES
         * ============================================================
         *
         * Given a string containing only '(' and ')', find the length
         * of the longest contiguous substring that forms valid,
         * correctly matched parentheses.
         *
         * EXAMPLE 1:
         *
         * Input:  "(()"
         *
         * Valid substring: "()"
         * Answer: 2
         *
         * EXAMPLE 2:
         *
         * Input:  ")()())"
         *
         * Longest valid substring: "()()"
         * Answer: 4
         *
         * EXAMPLE 3:
         *
         * Input:  "()(())"
         *
         * Entire string is valid.
         * Answer: 6
         *
         *
         * ============================================================
         * APPROACH: TWO COUNTERS (OPEN AND CLOSE)
         * ============================================================
         *
         * Instead of using a Stack, we maintain two counters:
         *
         * open  -> number of '(' encountered in the current segment.
         * close -> number of ')' encountered in the current segment.
         *
         * We scan the string in two directions:
         *
         * PASS 1: LEFT TO RIGHT
         * --------------------------------
         * 1. Count opening and closing brackets.
         * 2. If open == close, we have a valid candidate substring.
         * 3. If close > open, the current segment cannot be valid.
         *    Reset both counters and start a new segment.
         *
         * PASS 2: RIGHT TO LEFT
         * --------------------------------
         * 1. Count opening and closing brackets again, in reverse.
         * 2. If open == close, we have a valid candidate substring.
         * 3. If open > close, the current reverse-scanned segment
         *    contains too many opening brackets.
         *    Reset both counters.
         *
         * WHY TWO PASSES?
         *
         * Counting equal numbers alone is not sufficient.
         * A substring must also have correctly ordered brackets.
         *
         * For example:
         *
         * s = "(()"
         *
         * Left to right:
         * open = 2, close = 1
         *
         * The counts never become equal, so the valid substring "()"
         * would be missed in this pass.
         *
         * Right to left:
         * We encounter ')', then '(', and the counts become equal.
         * Therefore, we discover the valid substring "()" of length 2.
         *
         * The reverse pass handles cases where there are extra
         * opening brackets that the forward pass cannot resolve.
         *
         *
         * ============================================================
         * IMPORTANT INVARIANT
         * ============================================================
         *
         * We update maxLen ONLY when:
         *
         *                  open == close
         *
         * Equal counts give a valid candidate because the reset rule
         * prevents us from crossing an invalid boundary in the
         * direction being scanned.
         *
         * We do NOT update maxLen merely because open > close or
         * close > open.
         *
         * Those conditions indicate an imbalance, not a valid result.
         */


        /*
         * ------------------------------------------------------------
         * VARIABLE 1: open
         * ------------------------------------------------------------
         *
         * Counts the '(' characters encountered since the most
         * recent reset.
         *
         * Example:
         *
         * String: "(()"
         *
         * After reading the first '(':
         * open = 1
         *
         * After reading the second '(':
         * open = 2
         *
         * The counter increases whenever we encounter '('.
         */


        /*
         * ------------------------------------------------------------
         * VARIABLE 2: close
         * ------------------------------------------------------------
         *
         * Counts the ')' characters encountered since the most
         * recent reset.
         *
         * Example:
         *
         * String: "())"
         *
         * After reading '(':
         * open = 1, close = 0
         *
         * After reading the first ')':
         * open = 1, close = 1
         *
         * After reading the second ')':
         * open = 1, close = 2
         *
         * At this point, close > open.
         * There are more closing brackets than opening brackets.
         */


        /*
         * ------------------------------------------------------------
         * VARIABLE 3: maxLen
         * ------------------------------------------------------------
         *
         * Stores the length of the longest valid substring found
         * across BOTH passes.
         *
         * Initially, maxLen = 0 because we have not found any valid
         * non-empty substring yet.
         *
         * Whenever we discover a valid candidate, we compare its
         * length with maxLen and preserve the larger value.
         *
         * We do not reset maxLen between passes because the answer
         * found in the first pass must be retained.
         */

        int open = 0;
        int close = 0;
        int maxLen = 0;


        /*
         * ============================================================
         * PASS 1: TRAVERSE FROM LEFT TO RIGHT
         * ============================================================
         *
         * Direction:
         *
         * Index 0  --------------------->  Index s.length() - 1
         *
         * We start at the first character and move towards the last.
         *
         * PURPOSE:
         *
         * This pass detects segments where closing brackets never
         * outnumber opening brackets.
         *
         * If we encounter more closing brackets than opening
         * brackets, the segment is invalid and must be abandoned.
         *
         * Example:
         *
         * s = ")()()"
         *
         * The very first ')' cannot be matched by an opening bracket
         * to its left.
         *
         * Therefore, we reset the counters at that position.
         * The subsequent segment "()()" can then be counted normally.
         */

        for (int i = 0; i < s.length(); i++) {

            /*
             * Read the character at the current index.
             *
             * i represents the position we are currently processing.
             *
             * Example:
             *
             * s = "()"
             *
             * i = 0 -> '('
             * i = 1 -> ')'
             */

            char ch = s.charAt(i);


            /*
             * STEP 1: UPDATE THE APPROPRIATE COUNTER
             * ---------------------------------------
             *
             * If we encounter '(':
             * Increase open by 1.
             *
             * If we encounter ')':
             * Increase close by 1.
             *
             * We only need to count the brackets. We do not need to
             * store every character or every index in a Stack.
             */

            if (ch == '(') {

                // One more opening bracket has been encountered.
                open++;

            } else {

                // One more closing bracket has been encountered.
                close++;
            }


            /*
             * STEP 2: CHECK WHETHER THE COUNTS ARE EQUAL
             * ------------------------------------------
             *
             * CONDITION:
             *
             * open == close
             *
             * At this point, the current segment contains equal
             * numbers of opening and closing brackets.
             *
             * Because we reset whenever close > open, the segment
             * scanned since the latest reset has never had more
             * closing brackets than opening brackets at any prefix.
             *
             * Therefore, equal counts mean that this segment is valid.
             *
             * HOW DO WE CALCULATE ITS LENGTH?
             *
             * Every '(' contributes one opening bracket.
             * Every ')' contributes one closing bracket.
             *
             * When the counts are equal:
             *
             * Number of opening brackets = open
             * Number of closing brackets = close
             *
             * Total length = open + close
             *              = open + open
             *              = 2 * open
             *
             * Since open == close, we can use 2 * close as well.
             *
             * Example:
             *
             * open = 2
             * close = 2
             *
             * Candidate length = 2 * 2 = 4
             *
             * IMPORTANT:
             *
             * This candidate represents the balanced segment ending
             * at the current index, beginning just after the most
             * recent reset boundary.
             */

            if (open == close) {

                /*
                 * We have discovered a valid candidate substring.
                 *
                 * Math.max() compares:
                 *
                 * 1. maxLen:
                 *    The best answer discovered so far.
                 *
                 * 2. 2 * close:
                 *    The length of the newly discovered candidate.
                 *
                 * We preserve whichever value is larger.
                 */

                maxLen = Math.max(maxLen, 2 * close);
            }


            /*
             * STEP 3: HANDLE AN EXCESS OF CLOSING BRACKETS
             * --------------------------------------------
             *
             * CONDITION:
             *
             * close > open
             *
             * This means we have encountered more ')' characters
             * than '(' characters in the current segment.
             *
             * WHY IS THIS A PROBLEM?
             *
             * A valid parentheses substring cannot have more closing
             * brackets than opening brackets at any prefix.
             *
             * Example:
             *
             * s = "())"
             *
             * After processing the characters:
             *
             * '(' -> open = 1, close = 0
             * ')' -> open = 1, close = 1
             * ')' -> open = 1, close = 2
             *
             * At the last character:
             *
             * close > open
             *
             * The second ')' cannot be matched with an opening
             * bracket within the current segment.
             *
             * Any valid substring discovered after this point must
             * start AFTER this unmatched closing bracket.
             *
             * Therefore, we discard the counts for the old segment
             * and start counting a new segment from the next index.
             *
             * WHY RESET BOTH COUNTERS?
             *
             * open and close describe only the current candidate
             * segment. Once that segment becomes impossible, its
             * counts must not contaminate the next segment.
             *
             * IMPORTANT:
             *
             * We reset only the counters, NOT maxLen.
             * A previously discovered valid substring remains valid.
             */

            else if (close > open) {

                // Discard the counts belonging to the invalid segment.
                open = 0;
                close = 0;
            }


            /*
             * WHAT IF open > close?
             * ---------------------
             *
             * This is NOT an immediate reset condition in the
             * left-to-right pass.
             *
             * Example:
             *
             * s = "(()"
             *
             * After processing the complete string:
             *
             * open = 2
             * close = 1
             *
             * There are extra opening brackets.
             *
             * We cannot declare the entire segment valid because
             * the counts are unequal.
             *
             * However, we must not reset simply because open > close.
             * A valid substring may still be present inside this
             * segment.
             *
             * Example:
             *
             * s = "(()"
             *
             * The first two characters contain the valid substring
             * "()", but the whole string has an extra '('.
             *
             * The second, right-to-left pass handles this situation.
             *
             * Thus, in the forward pass:
             *
             * close > open -> RESET
             * open == close -> UPDATE ANSWER
             * open > close -> KEEP COUNTING
             */


        }


        /*
         * ============================================================
         * RESET THE COUNTERS BEFORE PASS 2
         * ============================================================
         *
         * We are about to traverse the same string in the opposite
         * direction.
         *
         * The counts from the first pass must not carry over because
         * the second pass starts a completely new counting process.
         *
         * maxLen is deliberately NOT reset.
         *
         * WHY?
         *
         * We want to retain the best answer from the first pass and
         * improve it if the second pass discovers a longer substring.
         */

        open = 0;
        close = 0;


        /*
         * ============================================================
         * PASS 2: TRAVERSE FROM RIGHT TO LEFT
         * ============================================================
         *
         * Direction:
         *
         * Index s.length() - 1  <---------------------  Index 0
         *
         * We start at the last character and move towards the first.
         *
         * WHY DO WE NEED THIS SECOND PASS?
         *
         * The forward pass resets when:
         *
         * close > open
         *
         * But it cannot always finish with equal counts when there
         * are extra opening brackets.
         *
         * Example:
         *
         * s = "(()"
         *
         * Forward pass:
         *
         * '(' -> open = 1, close = 0
         * '(' -> open = 2, close = 0
         * ')' -> open = 2, close = 1
         *
         * No point has equal counts.
         *
         * However, the substring "()" is valid and has length 2.
         *
         * The reverse pass finds it by processing:
         *
         * ')' -> open = 0, close = 1
         * '(' -> open = 1, close = 1
         *
         * At that point, the counts are equal, so we discover
         * the valid substring of length 2.
         *
         * In the reverse pass, we reset when open > close because
         * that means we have encountered too many opening brackets
         * relative to the closing brackets in the current
         * reverse-scanned segment.
         */


        for (int i = s.length() - 1; i >= 0; i--) {

            /*
             * Read the current character.
             *
             * Unlike the first pass, the index decreases each time.
             *
             * Example:
             *
             * s = "(()"
             *
             * First character processed: ')' at index 2
             * Second character processed: '(' at index 1
             * Third character processed: '(' at index 0
             */

            char ch = s.charAt(i);


            /*
             * STEP 1: UPDATE THE COUNTERS
             * ---------------------------
             *
             * The counters still have the same meanings:
             *
             * open  = number of '(' characters encountered.
             * close = number of ')' characters encountered.
             *
             * Only the traversal direction has changed.
             */

            if (ch == '(') {

                // Count one opening bracket.
                open++;

            } else {

                // Count one closing bracket.
                close++;
            }


            /*
             * STEP 2: CHECK FOR EQUAL COUNTS
             * ------------------------------
             *
             * When open == close, we have a valid candidate segment.
             *
             * The reverse-pass reset rule guarantees that the
             * reverse-scanned segment has never had more opening
             * brackets than closing brackets in any scanned prefix.
             *
             * Therefore, equal counts indicate a valid substring.
             *
             * LENGTH:
             *
             * Total characters = open + close
             * Since open == close:
             *
             * Length = 2 * open
             *
             * We compare this candidate with maxLen.
             *
             * maxLen already contains the best answer from the
             * first pass, so we keep whichever answer is longer.
             */

            if (open == close) {

                maxLen = Math.max(maxLen, 2 * open);
            }


            /*
             * STEP 3: HANDLE TOO MANY OPENING BRACKETS
             * ----------------------------------------
             *
             * CONDITION:
             *
             * open > close
             *
             * Because we are scanning backwards, this imbalance
             * indicates that the current segment has more opening
             * brackets than closing brackets.
             *
             * Such a segment cannot be valid as a whole.
             *
             * Example:
             *
             * s = "(()"
             *
             * Suppose we have already processed the final ')'
             * and then encounter the two opening brackets.
             *
             * Eventually:
             *
             * open = 2
             * close = 1
             *
             * The current reverse-scanned segment has an excess
             * of opening brackets.
             *
             * We reset the counters so that the next candidate
             * segment does not include this invalid boundary.
             *
             * WHY NOT RESET WHEN close > open HERE?
             *
             * The reverse pass is designed to handle the opposite
             * imbalance from the first pass.
             *
             * In this pass:
             *
             * open > close -> RESET
             * open == close -> UPDATE ANSWER
             * close > open -> KEEP COUNTING
             *
             * This complementary reset condition is what allows
             * the two-pass approach to find valid substrings that
             * the forward pass alone might miss.
             */

            else if (open > close) {

                // Discard the counts belonging to the invalid segment.
                open = 0;
                close = 0;
            }
        }


        /*
         * ============================================================
         * RETURN THE FINAL ANSWER
         * ============================================================
         *
         * maxLen stores the maximum length discovered in either pass.
         *
         * If the input contains no valid pair of parentheses,
         * maxLen remains 0.
         *
         * Examples:
         *
         * s = ""       -> 0
         * s = "))))"   -> 0
         * s = "(()"    -> 2
         * s = ")()())" -> 4
         * s = "()(())" -> 6
         *
         * The method returns the length, not the substring itself.
         */

        return maxLen;
    }


    /*
     * ================================================================
     * MAIN METHOD: TEST CASES
     * ================================================================
     *
     * Each print statement invokes longestValidParentheses() with a
     * different input and displays the returned maximum length.
     *
     * The comments after each call describe the expected output.
     */

    public static void main(String[] args) {

        // Extra opening bracket at the beginning.
        // The reverse pass finds the valid substring "()".
        System.out.println(longestValidParentheses("(()"));     // 2

        // Extra closing brackets at both ends.
        // The longest valid substring is "()()".
        System.out.println(longestValidParentheses(")()())"));  // 4

        // Empty input contains no valid parentheses substring.
        System.out.println(longestValidParentheses(""));        // 0

        // One matching pair of parentheses.
        System.out.println(longestValidParentheses("()"));      // 2

        // Contains an unmatched opening bracket.
        // The longest valid substring is "()".
        System.out.println(longestValidParentheses("()(()"));   // 2

        // The entire string is valid.
        // It contains six characters.
        System.out.println(longestValidParentheses("()(())"));  // 6

        // Only unmatched closing brackets; no valid pair exists.
        System.out.println(longestValidParentheses("))))"));    // 0
    }
}
