
// import java.util.*;

// public class CheckStringIsValidOrNot {

//     /*
//      * APPROACH 1: BRUTE FORCE
//      *
//      * Repeatedly find "abc" and remove it.
//      * Removing characters shifts the remaining characters.
//      *
//      * Time: O(n^2)
//      * Space: O(n) because StringBuilder stores the string.
//      */
//     public static boolean isValidBruteForce(String s) {

//         StringBuilder sb = new StringBuilder(s);

//         // Keep removing "abc" as long as it exists
//         while (true) {

//             int index = sb.indexOf("abc");

//             // No more "abc" found
//             if (index == -1) {
//                 break;
//             }

//             // Remove the three characters "abc"
//             sb.delete(index, index + 3);
//         }

//         // Valid if nothing remains
//         return sb.length() == 0;
//     }


//     /*
//      * APPROACH 2: OPTIMAL USING STACK
//      *
//      * Instead of building and repeatedly modifying the string,
//      * cancel characters whenever we encounter 'c'.
//      *
//      * For every 'c':
//      * 1. The stack top must be 'b'.
//      * 2. The next element must be 'a'.
//      * 3. Remove both characters.
//      *
//      * Time: O(n)
//      * Space: O(n)
//      */
//     public static boolean isValidOptimal(String s) {

//         Deque<Character> st = new ArrayDeque<>();

//         for (char ch : s.toCharArray()) {

//             if (ch == 'a' || ch == 'b') {

//                 // Store 'a' and 'b'
//                 st.push(ch);

//             } else if (ch == 'c') {

//                 // We need both 'a' and 'b'
//                 if (st.size() < 2) {
//                     return false;
//                 }

//                 // The first character must be 'b'
//                 if (st.peek() != 'b') {
//                     return false;
//                 }

//                 st.pop(); // Remove 'b'

//                 // The second character must be 'a'
//                 if (st.peek() != 'a') {
//                     return false;
//                 }

//                 st.pop(); // Remove 'a'

//             } else {

//                 // Reject characters other than a, b, and c
//                 return false;
//             }
//         }

//         // All characters must be consumed
//         return st.isEmpty();
//     }


//     public static void main(String[] args) {

//         String[] testCases = {
//             "abc",
//             "aabcbc",
//             "abcabc",
//             "abcc",
//             "cab",
//             "aabbcc",
//             "abcabcababcc"
//         };

//         for (String s : testCases) {

//             boolean brute = isValidBruteForce(s);
//             boolean optimal = isValidOptimal(s);

//             System.out.println(
//                 s + " -> Brute Force: " + brute
//                 + ", Optimal: " + optimal
//             );
//         }
//     }
// }
// */

import java.util.*;

public class CheckStringIsValidOrNot {

    public static boolean isValid(String s) {

        Deque<Character> st = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {

            // If character is 'a' or 'b', push it onto the stack
            if (ch == 'a' || ch == 'b') {
                st.push(ch);
            } else {

                // We encountered 'c'.
                // We need two characters: 'b' followed by 'a'.
                if (st.size() < 2) {
                    return false;
                }

                // First, the top element must be 'b'
                if (st.peek() != 'b') {
                    return false;
                }

                st.pop(); // Remove 'b'

                // Now, the top element must be 'a'
                if (st.peek() != 'a') {
                    return false;
                }

                st.pop(); // Remove 'a'
            }
        }

        // Valid only if every character has been matched
        return st.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(isValid("abc"));       // true
        System.out.println(isValid("aabcbc"));    // true
        System.out.println(isValid("abcabc"));    // true
        System.out.println(isValid("abcc"));      // false
        System.out.println(isValid("cab"));       // false
        System.out.println(isValid("aabbcc"));    // false
    }
}
