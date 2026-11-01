
import java.util.*;

public class PreviousSmallerElement {

    public static ArrayList<Integer> previousSmallerElement(int[] arr) {

        ArrayList<Integer> result = new ArrayList<>();

        // Initially, assume no Previous Smaller Element exists.
        // If no smaller element is found, answer remains -1.
        for (int i = 0; i < arr.length; i++) {
            result.add(-1);
        }

        // Monotonic Increasing Stack.
        // Stores potential Previous Smaller Elements.
        Deque<Integer> st = new ArrayDeque<>();

        int n = arr.length;

        // Traverse from LEFT to RIGHT.
        for (int i = 0; i < n; i++) {

            int curr = arr[i];

            /*
             * STEP 1: Remove useless elements.
             *
             * We need an element STRICTLY smaller than curr.
             *
             * Therefore:
             * - Elements greater than curr are useless.
             * - Elements equal to curr are also useless.
             *
             * Pop all elements >= curr.
             */
            while (!st.isEmpty() && st.peek() >= curr) {

                // Remove elements that cannot be our answer.
                st.pop();
            }

            /*
             * STEP 2: Find Previous Smaller Element.
             *
             * Case 1: Stack is empty.
             *         No smaller element exists on the left.
             *         Answer remains -1.
             *
             * Case 2: Stack is not empty.
             *         Stack top is the nearest smaller element.
             */
            if (!st.isEmpty()) {

                result.set(i, st.peek());
            }

            /*
             * STEP 3: Push current element.
             *
             * Current element can potentially become
             * the Previous Smaller Element for upcoming
             * elements on its RIGHT.
             */
            st.push(curr);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {4, 8, 5, 2, 25};

        ArrayList<Integer> result = previousSmallerElement(arr);

        System.out.println("Input:  " + Arrays.toString(arr));
        System.out.println("Output: " + result);
    }
}
