public class ReverseWords {

    static String reverseWords(String s) {

        // Final answer will be built here
        StringBuilder ans = new StringBuilder();

        // Start from the last character of the string
        int i = s.length() - 1;

        // Process the string from right to left
        while (i >= 0) {

            // Skip all spaces
            // Example: "hello world   "
            // Move i left until it reaches a non-space character
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            // If we went past the beginning, no words are left
            if (i < 0) {
                break;
            }

            // j starts at the end of the current word
            int j = i;

            // Move j left until a space is found
            // This helps us find the start of the word
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }

            /*
             * At this point:
             *
             * String = "the sky is blue"
             *
             *                i
             *                ↓
             * "the sky is blue"
             *            ↑
             *            j
             *
             * j is standing on the space before the word
             * i is standing on the last character of the word
             *
             * Word starts at (j + 1)
             * Word ends at i
             */

            // Extract the current word and append it
            // substring(start, end)
            // end index is exclusive, so use i + 1
            ans.append(s.substring(j + 1, i + 1));

            /*
             * Example:
             *
             * s = "the sky is blue"
             *
             * j = 10 (space before blue)
             * i = 14 ('e')
             *
             * substring(11, 15)
             * => "blue"
             */

            // Move j left over any extra spaces
            // Example:
            // "hello     world"
            //         ↑
            //         j
            //
            // Skip all spaces so j reaches the previous word
            while (j >= 0 && s.charAt(j) == ' ') {
                j--;
            }

            // If there are still words remaining,
            // add exactly one space to the answer
            if (j >= 0) {
                ans.append(' ');
            }

            /*
             * Example:
             *
             * Current answer:
             * "blue "
             *
             * Now we need to process the remaining part:
             * "the sky is"
             *
             * j currently points somewhere inside "is"
             */

            // Move i to the end of the remaining string
            // Next iteration will process the previous word
            i = j;
        }

        // Convert StringBuilder to String and return
        return ans.toString();
    }

    public static void main(String[] args) {

        String s = "  the   sky   is   blue  ";

        String ans = reverseWords(s);

        System.out.println(ans);
    }
}