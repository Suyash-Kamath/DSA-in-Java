
import java.util.*;

public class NextSmallerElementStoreIndex {

    public static ArrayList<Integer> nextSmallerElement(int[] arr) {

        int n = arr.length;

        ArrayList<Integer> result = new ArrayList<>();

        // Initially, no Next Smaller Element exists.
        for (int i = 0; i < n; i++) {
            result.add(-1);
        }

        // Store INDEXES instead of actual values.
        Deque<Integer> st = new ArrayDeque<>();

        // Traverse from RIGHT to LEFT.
        for (int i = n - 1; i >= 0; i--) {

            int curr = arr[i];

            /*
             * STEP 1: Remove useless indexes.
             *
             * st.peek() gives an index.
             * arr[st.peek()] gives the actual element.
             *
             * Remove elements >= current element
             * because we need a STRICTLY smaller element.
             */
            while (!st.isEmpty() && arr[st.peek()] >= curr) {
                st.pop();
            }

            /*
             * STEP 2: Find Next Smaller Element.
             *
             * Stack top contains the index of
             * the nearest smaller element on the right.
             */
            if (!st.isEmpty()) {

                // Store the INDEX of the Next Smaller Element.
                result.set(i, st.peek());
            }

            /*
             * STEP 3: Push current INDEX.
             *
             * It can become the Next Smaller Element
             * for elements appearing on its LEFT.
             */
            st.push(i);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {4, 8, 5, 2, 25};

        ArrayList<Integer> result = nextSmallerElement(arr);

        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Next Smaller Indexes: " + result);
    }
}
