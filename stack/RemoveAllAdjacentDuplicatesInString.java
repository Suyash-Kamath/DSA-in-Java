/*Approach 1


// public class RemoveAllAdjacentDuplicatesInString {

//     public static String removeDuplicates(String s) {

//         /*
//          * APPROACH 1: BRUTE FORCE
//          *
//          * Step 1: Traverse the string and find adjacent duplicates.
//          * Step 2: If s.charAt(i) == s.charAt(i + 1),
//          *         remove both characters.
//          * Step 3: Start checking again because removing a pair
//          *         can create new adjacent duplicates.
//          * Step 4: Repeat until no adjacent duplicates exist.
//          */

//         StringBuilder str = new StringBuilder(s);

//         boolean foundDuplicate = true;

//         while (foundDuplicate) {

//             foundDuplicate = false;

//             for (int i = 0; i < str.length() - 1; i++) {

//                 // Check whether two adjacent characters are equal.
//                 if (str.charAt(i) == str.charAt(i + 1)) {

//                     // Remove both adjacent duplicate characters.
//                     str.delete(i, i + 2);

//                     foundDuplicate = true;

//                     // A pair was removed, so restart the scan.
//                     break;
//                 }
//             }
//         }

//         return str.toString();
//     }

//     public static void main(String[] args) {

//         System.out.println(removeDuplicates("abbaca")); // ca
//         System.out.println(removeDuplicates("azxxzy")); // ay
//         System.out.println(removeDuplicates("aabb"));   // ""
//         System.out.println(removeDuplicates("abcd"));   // abcd
//     }
// }

/*


Using string builder instead of stack 


public class RemoveAllAdjacentDuplicatesInString {

    public static String removeDuplicates(String s) {

       
         // * APPROACH 2: OPTIMAL SOLUTION USING STRINGBUILDER
         // *
         // * Idea:
         // * Treat StringBuilder as a stack.
         // *
         // * The last character of StringBuilder represents the
         // * top of the stack.
         // *
         // * 1. Traverse the input string from left to right.
         // * 2. If StringBuilder is not empty and its last character
         // *    equals the current character, remove the last character.
         // * 3. Otherwise, append the current character.
         // * 4. Return StringBuilder as the final answer.
         

        StringBuilder str = new StringBuilder();

        for (char ch : s.toCharArray()) {

            // If the last character matches the current character,
            // both adjacent duplicates cancel each other out.
            if (str.length() > 0 &&
                str.charAt(str.length() - 1) == ch) {

                // Remove the last character.
                str.deleteCharAt(str.length() - 1);

            } else {

                // No matching adjacent character: keep the current one.
                str.append(ch);
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {

        System.out.println(removeDuplicates("abbaca")); // ca
        System.out.println(removeDuplicates("azxxzy")); // ay
        System.out.println(removeDuplicates("aabb"));   // ""
        System.out.println(removeDuplicates("abcd"));   // abcd
    }
}


*/

import java.util.*;

public class RemoveAllAdjacentDuplicatesInString {

    public static String removeDuplicates(String s) {

        /*
         * APPROACH 1: BRUTE FORCE
         *
         * 1. Search for adjacent duplicate characters.
         * 2. Remove them by shifting the remaining characters.
         * 3. Repeat the process because removing a pair can
         *    create new adjacent duplicates.
         *
         * Time Complexity: O(N^2) in the worst case.
         *
         *
         * APPROACH 2: OPTIMAL SOLUTION USING STACK
         *
         * Observation:
         * We are cancelling out adjacent equal characters.
         * This is a pattern where a Stack is useful.
         *
         * Logic:
         * 1. Traverse the string from left to right.
         * 2. If the stack is empty, push the current character.
         * 3. If the stack's top equals the current character,
         *    pop the top. Both characters cancel each other.
         * 4. Otherwise, push the current character.
         *
         * Why does this work?
         * The stack's top represents the last character that
         * has not yet been cancelled.
         *
         * After cancelling a pair, the next character we process
         * can interact with the newly exposed stack top.
         */

        Deque<Character> st = new ArrayDeque<>();

        // Process each character from left to right.
        for (char ch : s.toCharArray()) {

            // Case 1: Stack is empty.
            // There is no previous unmatched character to cancel.
            if (st.isEmpty()) {
                st.push(ch);
            }

            // Case 2: Current character matches the stack top.
            // These adjacent characters cancel each other out.
            else if (st.peek() == ch) {
                st.pop();
            }

            // Case 3: Characters are different.
            // Keep the current character for possible future matching.
            else {
                st.push(ch);
            }
        }

        /*
         * BUILD THE FINAL ANSWER
         *
         * The stack stores characters in reverse order.
         *
         * Example:
         * Original remaining characters: "abc"
         * Stack top-to-bottom:            c, b, a
         *
         * Popping produces "cba".
         * Reversing it gives "abc".
         */

        StringBuilder str = new StringBuilder();

        while (!st.isEmpty()) {
            str.append(st.pop());
        }

        // Restore the original left-to-right order.
        return str.reverse().toString();
    }

    public static void main(String[] args) {

        String s1 = "abbaca";
        System.out.println(removeDuplicates(s1)); // ca

        String s2 = "azxxzy";
        System.out.println(removeDuplicates(s2)); // ay

        String s3 = "aabb";
        System.out.println(removeDuplicates(s3)); // ""

        String s4 = "abcd";
        System.out.println(removeDuplicates(s4)); // abcd

        String s5 = "aaaa";
        System.out.println(removeDuplicates(s5)); // ""
    }
}
