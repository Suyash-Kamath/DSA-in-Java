
import java.util.*;

public class NextSmallerElement {

    public static ArrayList<Integer> nextSmallerElement(int[] arr) {

        // Stores the Next Smaller Element for every index.
        // Initially, assume that no smaller element exists.
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            result.add(-1);
        }

        // Monotonic Increasing Stack:
        // Stores potential Next Smaller Elements.
        // We process the array from RIGHT to LEFT.
        Deque<Integer> st = new ArrayDeque<>();

        int n = arr.length;

        for (int i = n - 1; i >= 0; i--) {

            int curr = arr[i];

            /*
             * STEP 1: Remove useless elements.
             *
             * We need an element STRICTLY smaller than curr.
             *
             * Therefore:
             * - Elements greater than curr cannot be our answer.
             * - Elements equal to curr cannot be our answer either.
             *
             * Remove all elements >= curr.
             */
            while (!st.isEmpty() && st.peek() >= curr) {
                st.pop();
            }

            /*
             * STEP 2: Find the Next Smaller Element.
             *
             * After removing useless elements:
             *
             * Case 1: Stack is empty
             *         No smaller element exists on the right.
             *         Answer remains -1.
             *
             * Case 2: Stack is not empty
             *         The top element is our Next Smaller Element.
             */
            if (!st.isEmpty()) {
                result.set(i, st.peek());
            }

            /*
             * STEP 3: Push the current element.
             *
             * The current element can potentially be
             * the Next Smaller Element for elements
             * appearing to its LEFT.
             */
            st.push(curr);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {4, 8, 5, 2, 25};

        ArrayList<Integer> result = nextSmallerElement(arr);

        System.out.println("Input:  " + Arrays.toString(arr));
        System.out.println("Output: " + result);
    }
}
