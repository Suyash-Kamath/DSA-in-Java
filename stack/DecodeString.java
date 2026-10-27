/*
Recursion Approach



public class DecodeString {

    private static int index = 0;

    public static String decodeString(String s) {
        index = 0;
        return decode(s);
    }

    private static String decode(String s) {

        StringBuilder curr = new StringBuilder();
        int number = 0;

        while (index < s.length()) {

            char ch = s.charAt(index);
            index++;

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }
            else if (ch == '[') {

                String inner = decode(s);

                for (int i = 0; i < number; i++) {
                    curr.append(inner);
                }

                number = 0;
            }
            else if (ch == ']') {
                return curr.toString();
            }
            else {
                curr.append(ch);
            }
        }

        return curr.toString();
    }

    public static void main(String[] args) {
        String input = "3[a2[c]]";
        System.out.println(decodeString(input));
    }
}


*/
import java.util.*;

public class DecodeString {

    public static String decodeString(String s) {

        /*
         * ============================================================
         * APPROACH: SIMULATE RECURSION USING STACKS
         * ============================================================
         *
         * Bhai, recursion vaali vibe aa rahi hai, right?
         *
         * Think about this encoded string:
         *
         *                  3[a2[c]]
         *
         * To decode it correctly, we must first decode the INNER
         * expression 2[c], then use its result to decode the OUTER
         * expression 3[...].
         *
         * This creates a dependency:
         *
         *     Outer expression depends on inner expression.
         *
         * We cannot completely decode the outer expression until
         * the inner expression has been decoded.
         *
         * ------------------------------------------------------------
         * HOW WOULD RECURSION SOLVE THIS?
         * ------------------------------------------------------------
         *
         * A recursive solution would:
         *
         * 1. Enter the outer bracket.
         * 2. Encounter another opening bracket.
         * 3. Enter the inner bracket.
         * 4. Decode the inner expression first.
         * 5. Return the inner result to the outer expression.
         * 6. Finish decoding the outer expression.
         *
         * When a recursive function pauses at an inner function call,
         * the program must remember its current state:
         *
         *     - What was the repetition count?
         *     - What string had already been built?
         *     - Where should execution continue after returning?
         *
         * The call stack automatically remembers this information
         * during recursion.
         *
         * ------------------------------------------------------------
         * HOW CAN WE DO THE SAME THING USING STACKS?
         * ------------------------------------------------------------
         *
         * We manually save the information that recursion would
         * otherwise remember for us.
         *
         * We need TWO stacks:
         *
         * 1. countStack:
         *    Stores repetition counts for unfinished brackets.
         *
         * 2. stringStack:
         *    Stores the string built before entering each bracket.
         *
         * We also maintain:
         *
         * 3. number:
         *    Builds the current repetition count.
         *
         * 4. curr:
         *    Builds the string at the current nesting level.
         *
         * The key observation is:
         *
         *     Opening '['  -> Save the current context.
         *     Closing ']'  -> Restore that context and finish the
         *                     nested expression.
         *
         * This is the same LAST-IN, FIRST-OUT behaviour as recursion:
         *
         *     The innermost unfinished expression gets completed first.
         *
         * Example:
         *
         *     3[a2[c]]
         *
         *     Decode 2[c] first  -> "cc"
         *     Attach it to "a"   -> "acc"
         *     Repeat "acc" 3x    -> "accaccacc"
         *
         * Final answer: "accaccacc"
         */


        /*
         * ============================================================
         * STACK 1: countStack
         * ============================================================
         *
         * WHY DO WE NEED THIS STACK?
         *
         * Every opening bracket has a repetition count associated
         * with it.
         *
         * In 3[a2[c]]:
         *
         *     The outer bracket has count 3.
         *     The inner bracket has count 2.
         *
         * When we encounter the outer '[':
         *
         *     countStack = [3]
         *
         * When we encounter the inner '[':
         *
         *     countStack = [3, 2]
         *                  bottom  top
         *
         * When the first ']' appears, it belongs to the INNER bracket.
         * Therefore, we must retrieve 2, not 3.
         *
         * countStack.pop() gives us 2 first.
         *
         * The remaining 3 stays on the stack until the outer ']'.
         *
         * WHY A STACK INSTEAD OF A SINGLE INTEGER?
         *
         * A single integer cannot remember multiple unfinished counts.
         * The outer count 3 would be overwritten when we read 2.
         *
         * The stack preserves all unfinished counts in their correct
         * nesting order.
         */
        Deque<Integer> countStack = new ArrayDeque<>();


        /*
         * ============================================================
         * STACK 2: stringStack
         * ============================================================
         *
         * WHY DO WE NEED THIS STACK?
         *
         * We must remember the string that existed BEFORE entering
         * an opening bracket.
         *
         * Consider:
         *
         *     3[a2[c]]
         *
         * When we reach the inner '[':
         *
         *     curr = "a"
         *
         * We must save "a" before resetting curr to "".
         *
         * Therefore, we push "a" onto stringStack.
         *
         * Later, when the inner ']' appears:
         *
         *     Inner decoded string = "cc"
         *     Previous string      = "a"
         *
         * We combine them:
         *
         *     "a" + "cc" = "acc"
         *
         * Without stringStack, resetting curr would lose the "a".
         *
         * WHY A STACK INSTEAD OF A SINGLE STRING VARIABLE?
         *
         * Because nested brackets can have multiple previous strings.
         *
         * For this example, the saved strings are:
         *
         *     First push:  ""
         *     Second push: "a"
         *
         * The inner closing bracket must retrieve "a" first.
         * The outer closing bracket must retrieve "" afterwards.
         *
         * A stack ensures that we restore these strings in the
         * correct reverse order.
         */
        Deque<StringBuilder> stringStack = new ArrayDeque<>();


        /*
         * ============================================================
         * VARIABLE 1: number
         * ============================================================
         *
         * PURPOSE:
         *
         * Builds a repetition count digit by digit.
         *
         * Example:
         *
         *     Input begins with 12[a]
         *
         *     Read '1':
         *         number = 0 * 10 + 1 = 1
         *
         *     Read '2':
         *         number = 1 * 10 + 2 = 12
         *
         * WHY MULTIPLY BY 10?
         *
         * We need to shift the previously built digits left to make
         * room for the next digit.
         *
         * Once '[' is encountered, the complete number is pushed onto
         * countStack, and number is reset to 0.
         */
        int number = 0;


        /*
         * ============================================================
         * VARIABLE 2: curr
         * ============================================================
         *
         * PURPOSE:
         *
         * Stores the string we are currently constructing.
         *
         * Initially:
         *
         *     curr = ""
         *
         * After reading 'a':
         *
         *     curr = "a"
         *
         * When we encounter an opening bracket, the current string
         * is saved on stringStack, and curr is reset.
         *
         * This allows us to build the inner string independently.
         *
         * IMPORTANT:
         *
         * curr represents the string at the CURRENT nesting level.
         * It does not always represent the complete decoded answer.
         *
         * Once an inner expression is finished, its decoded result
         * becomes part of the enclosing expression.
         */
        StringBuilder curr = new StringBuilder();


        /*
         * ============================================================
         * PROCESS THE INPUT FROM LEFT TO RIGHT
         * ============================================================
         *
         * We inspect every character exactly once.
         *
         * Each character belongs to one of four cases:
         *
         * CASE 1: Digit       -> Build number.
         * CASE 2: '['         -> Save the current context.
         * CASE 3: ']'         -> Decode the inner expression and
         *                        reconnect it to the previous string.
         * CASE 4: Letter      -> Append it to curr.
         *
         * The order of these operations is important because brackets
         * determine when a nested expression begins and ends.
         */
        for (char ch : s.toCharArray()) {


            /*
             * ========================================================
             * CASE 1: DIGIT
             * ========================================================
             *
             * Example:
             *
             *     ch = '3'
             *     number = 0
             *
             *     number = number * 10 + (ch - '0')
             *     number = 0 * 10 + 3
             *     number = 3
             *
             * We do not push the number immediately because the count
             * may contain multiple digits.
             *
             * We keep building number until the next non-digit
             * character is encountered.
             */
            if (Character.isDigit(ch)) {

                number = number * 10 + (ch - '0');

            }


            /*
             * ========================================================
             * CASE 2: OPENING BRACKET '['
             * ========================================================
             *
             * LOGIC:
             *
             * We are entering a new nested expression.
             *
             * Before entering it, save:
             *
             *     1. The repetition count.
             *     2. The string constructed so far.
             *
             * Then start fresh for the inner expression.
             *
             * EXAMPLE: 3[a2[c]]
             *
             * At the outer '[':
             *
             *     number = 3
             *     curr = ""
             *
             *     Push 3 onto countStack.
             *     Push "" onto stringStack.
             *
             * At the inner '[':
             *
             *     number = 2
             *     curr = "a"
             *
             *     Push 2 onto countStack.
             *     Push "a" onto stringStack.
             *
             * WHY RESET number?
             *
             * The count has already been saved.
             * We must not accidentally carry the outer count into
             * the next repetition count.
             *
             * WHY RESET curr?
             *
             * We need to build the inner expression separately.
             *
             * The previous string is not lost because we saved it
             * on stringStack before resetting curr.
             */
            else if (ch == '[') {

                // Save the repetition count for this opening bracket.
                countStack.push(number);

                // Save the string constructed before entering the bracket.
                //
                // StringBuilder is mutable, so save a COPY of its
                // current contents rather than the same object.
                //
                // This prevents later changes to curr from modifying
                // the string saved on the stack.
                stringStack.push(new StringBuilder(curr));

                // The current count has been saved.
                // Start building the next count from zero.
                number = 0;

                // Start with an empty string inside this bracket.
                curr = new StringBuilder();

            }


            /*
             * ========================================================
             * CASE 3: CLOSING BRACKET ']'
             * ========================================================
             *
             * THIS IS THE MOST IMPORTANT CASE.
             *
             * A closing bracket means:
             *
             *     "The current inner expression is complete."
             *
             * We now need to:
             *
             *     1. Retrieve its repetition count.
             *     2. Retrieve the previous string.
             *     3. Repeat curr the required number of times.
             *     4. Append the repeated result to the previous string.
             *     5. Store the combined result back in curr.
             *
             * This is where we move from the INNER nesting level
             * back to the OUTER nesting level.
             *
             * EXAMPLE:
             *
             *     3[a2[c]]
             *
             * Just before the first ']':
             *
             *     curr = "c"
             *
             *     countStack = [3, 2]
             *     stringStack = ["", "a"]
             *
             * The top count is 2.
             * The top previous string is "a".
             *
             * We decode:
             *
             *     2["c"] = "cc"
             *
             * Then combine:
             *
             *     "a" + "cc" = "acc"
             *
             * So curr becomes "acc".
             *
             * We have now finished the inner bracket, but NOT the
             * outer bracket.
             */


            else if (ch == ']') {


                /*
                 * STEP 3A: RETRIEVE THE REPETITION COUNT
                 *
                 * pop() returns and removes the top stack element.
                 *
                 * For the first ']':
                 *
                 *     countStack = [3, 2]
                 *
                 * The top is 2, so:
                 *
                 *     repeatCount = 2
                 *
                 * The outer count 3 remains on the stack.
                 *
                 * We process the innermost unfinished bracket first
                 * because stacks follow Last In, First Out.
                 */
                int repeatCount = countStack.pop();


                /*
                 * STEP 3B: RETRIEVE THE PREVIOUS STRING
                 *
                 * This is the string that existed before we entered
                 * the current opening bracket.
                 *
                 * For the first ']':
                 *
                 *     stringStack = ["", "a"]
                 *
                 * Pop the top:
                 *
                 *     prev = "a"
                 *
                 * We will append the repeated inner string to prev.
                 *
                 * IMPORTANT:
                 *
                 * curr currently contains ONLY the decoded string
                 * inside the bracket. It does not contain the
                 * previously saved outer string.
                 */
                StringBuilder prev = stringStack.pop();


                /*
                 * STEP 3C: REPEAT curr AND APPEND IT TO prev
                 *
                 * This loop implements the meaning of:
                 *
                 *     number[string]
                 *
                 * which means:
                 *
                 *     Repeat "string" exactly "number" times.
                 *
                 * For our example:
                 *
                 *     repeatCount = 2
                 *     curr = "c"
                 *     prev = "a"
                 *
                 * Initially:
                 *
                 *     prev = "a"
                 *
                 * First iteration:
                 *
                 *     prev.append(curr)
                 *     prev = "ac"
                 *
                 * Second iteration:
                 *
                 *     prev.append(curr)
                 *     prev = "acc"
                 *
                 * The inner expression is now decoded and combined
                 * with the previous string.
                 *
                 * WHY DO WE APPEND curr TO prev?
                 *
                 * Because curr contains the inner string, while prev
                 * contains the string that existed before the inner
                 * bracket was opened.
                 *
                 * The required result is:
                 *
                 *     previous string + repeated inner string
                 *
                 * Appending curr repeatedly to prev performs both
                 * operations in one loop.
                 *
                 * NOTE:
                 *
                 * The loop starts at i = 1 and continues while
                 * i <= repeatCount.
                 *
                 * Therefore, when repeatCount = 2, it runs twice.
                 */
                for (int i = 1; i <= repeatCount; i++) {

                    prev.append(curr);

                }


                /*
                 * STEP 3D: THE MOST IMPORTANT LINE
                 *
                 *     curr = prev;
                 *
                 * Why do we assign prev back to curr?
                 *
                 * Because we have finished decoding the current
                 * nested expression.
                 *
                 * The combined string now represents the decoded
                 * result at the OUTER nesting level.
                 *
                 * FIRST CLOSING BRACKET:
                 *
                 * Before the loop:
                 *
                 *     prev = "a"
                 *     curr = "c"
                 *     repeatCount = 2
                 *
                 * After the loop:
                 *
                 *     prev = "acc"
                 *
                 * Assignment:
                 *
                 *     curr = prev
                 *
                 * Now:
                 *
                 *     curr = "acc"
                 *
                 * SECOND CLOSING BRACKET:
                 *
                 * Before the loop:
                 *
                 *     prev = ""
                 *     curr = "acc"
                 *     repeatCount = 3
                 *
                 * After the loop:
                 *
                 *     prev = "accaccacc"
                 *
                 * Assignment:
                 *
                 *     curr = prev
                 *
                 * Now:
                 *
                 *     curr = "accaccacc"
                 *
                 * RECURSION CONNECTION:
                 *
                 * Think of this assignment as returning the decoded
                 * result from an inner recursive call to its caller.
                 *
                 * The stack approach does this manually:
                 *
                 *     Save outer context -> Enter inner expression.
                 *     Decode inner expression.
                 *     Restore outer context -> Continue outer expression.
                 *
                 * That is why stack-based decoding and recursive
                 * decoding follow the same nesting principle.
                 */
                curr = prev;

            }


            /*
             * ========================================================
             * CASE 4: NORMAL CHARACTER
             * ========================================================
             *
             * If the character is not a digit, '[' or ']', it is
             * a normal character in the encoded string.
             *
             * Append it to curr because it belongs to the string
             * currently being constructed.
             *
             * EXAMPLE:
             *
             *     curr = ""
             *     ch = 'a'
             *
             *     curr.append(ch)
             *
             *     curr = "a"
             *
             * We do not repeat anything here.
             *
             * Repetition happens when we encounter the closing bracket
             * and retrieve the saved repetition count.
             */
            else {

                curr.append(ch);

            }

        }


        /*
         * ============================================================
         * FINAL STEP: RETURN THE DECODED STRING
         * ============================================================
         *
         * After the loop finishes, every character has been processed.
         *
         * For the input:
         *
         *     3[a2[c]]
         *
         * The important changes to curr were:
         *
         *     "c"   -> "acc" -> "accaccacc"
         *
         * The final curr contains the completely decoded string.
         *
         * StringBuilder is used internally because we need to append
         * characters and repeated strings.
         *
         * The method's return type is String, so we convert curr
         * into a String before returning it.
         */
        return curr.toString();

    }


    /*
     * ================================================================
     * MAIN METHOD: TEST THE APPROACH
     * ================================================================
     *
     * This is where we provide an encoded string and print the answer.
     */
    public static void main(String[] args) {

        // Input:
        // 3[a2[c]]
        //
        // Expected decoding:
        //
        //     2[c]  -> "cc"
        //     a + cc -> "acc"
        //     3[acc] -> "accaccacc"
        String input = "3[a2[c]]";

        // Call the method that uses our two-stack approach.
        String result = decodeString(input);

        // Print the decoded result.
        System.out.println(result);

        // Expected output:
        // accaccacc
    }
}
