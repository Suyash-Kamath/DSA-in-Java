// public class MostFrequentCharacter {

//     static char getMaxOccuringChar(String s) {

//         // Frequency array of size 26
//         // Index 0 -> 'a'
//         // Index 1 -> 'b'
//         // ...
//         // Index 25 -> 'z'
//         int[] freq = new int[26];

//         // --------------------------------------------------
//         // STEP 1: Count frequency of every character
//         // --------------------------------------------------

//         for (int i = 0; i < s.length(); i++) {

//             // Current character from the string
//             char currentChar = s.charAt(i);

//             /*
//              * Convert character into array index
//              *
//              * Example:
//              * currentChar = 'a'
//              * 'a' - 'a' = 0
//              *
//              * currentChar = 'c'
//              * 'c' - 'a' = 2
//              *
//              * currentChar = 'z'
//              * 'z' - 'a' = 25
//              */

//             int index = currentChar - 'a';

//             // Increase frequency of this character
//             freq[index]++;
//         }

//         // --------------------------------------------------
//         // STEP 2: Find character having maximum frequency
//         // --------------------------------------------------

//         int maxFreq = -1;

//         // Default answer
//         char ans = 'a';

//         /*
//          * Traverse frequency array.
//          *
//          * Since the array is already arranged in alphabetical order:
//          *
//          * index 0 -> a
//          * index 1 -> b
//          * index 2 -> c
//          * ...
//          * index 25 -> z
//          *
//          * If multiple characters have the same frequency,
//          * the first one encountered will automatically be
//          * lexicographically smaller.
//          *
//          * Example:
//          *
//          * a -> 3
//          * b -> 3
//          *
//          * When i = 0, answer becomes 'a'
//          * When i = 1, freq[1] is NOT greater than maxFreq
//          * so answer remains 'a'
//          */

//         for (int i = 0; i < 26; i++) {

//             // Found a better frequency
//             if (freq[i] > maxFreq) {

//                 maxFreq = freq[i];

//                 /*
//                  * Convert array index back to character
//                  *
//                  * Example:
//                  * i = 0
//                  * (char)(0 + 'a')
//                  * => 'a'
//                  *
//                  * i = 2
//                  * (char)(2 + 'a')
//                  * => 'c'
//                  */

//                 ans = (char) (i + 'a');
//             }
//         }

//         return ans;
//     }

//     public static void main(String[] args) {

//         String s = "testsample";

//         char ans = getMaxOccuringChar(s);

//         System.out.println("Most Frequent Character: " + ans);
//     }
// }



// Hashmap approach

import java.util.HashMap;

public class MostFrequentCharacter {

    static char getMaxOccuringChar(String s) {

        // HashMap stores:
        // Character -> Frequency
        //
        // Example:
        // "testsample"
        //
        // {
        //   t=2,
        //   e=2,
        //   s=2,
        //   a=1,
        //   m=1,
        //   p=1,
        //   l=1
        // }
        HashMap<Character, Integer> freqMap = new HashMap<>();

        // --------------------------------------------------
        // STEP 1: Count frequency of every character
        // --------------------------------------------------

        for (int i = 0; i < s.length(); i++) {

            // Pick current character
            char currentChar = s.charAt(i);

            /*
             * getOrDefault(key, defaultValue)
             *
             * If key exists:
             *     return its value
             *
             * Otherwise:
             *     return default value
             *
             * Example:
             *
             * freqMap = {}
             *
             * currentChar = 't'
             *
             * getOrDefault('t',0)
             * => 0
             */

            int currentFreq = freqMap.getOrDefault(currentChar, 0);

            // Increase frequency by 1
            freqMap.put(currentChar, currentFreq + 1);
        }

        // --------------------------------------------------
        // STEP 2: Find maximum frequency character
        // --------------------------------------------------

        int maxFreq = -1;

        // Default answer
        char ans = 'a';

        /*
         * Important:
         *
         * HashMap does NOT maintain lexicographical order.
         *
         * So instead of traversing HashMap,
         * we traverse from 'a' to 'z'.
         *
         * This guarantees that if multiple characters
         * have the same frequency, the lexicographically
         * smallest one is chosen.
         */

        for (char ch = 'a'; ch <= 'z'; ch++) {

            int currentFreq = freqMap.getOrDefault(ch, 0);

            if (currentFreq > maxFreq) {
                maxFreq = currentFreq;
                ans = ch;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        String s = "testsample";

        char ans = getMaxOccuringChar(s);

        System.out.println("Most Frequent Character: " + ans);
    }
}