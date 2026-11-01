
import java.util.*;

public class PreviousSmallerElementStoreIndex {

    public static ArrayList<Integer> previousSmallerElement(int[] arr) {

        int n = arr.length;

        ArrayList<Integer> result = new ArrayList<>();

        // Initially, no Previous Smaller Element exists.
        for (int i = 0; i < n; i++) {
            result.add(-1);
        }

        // Store INDEXES instead of actual values.
        Deque<Integer> st = new ArrayDeque<>();

        // Traverse from LEFT to RIGHT.
        for (int i = 0; i < n; i++) {

            int curr = arr[i];

            /*
             * STEP 1: Remove useless indexes.
             *
             * arr[st.peek()] gives the actual element
             * corresponding to the index at stack top.
             *
             * Remove elements >= current element
             * because we need a STRICTLY smaller element.
             */
            while (!st.isEmpty() && arr[st.peek()] >= curr) {
                st.pop();
            }

            /*
             * STEP 2: Find Previous Smaller Element.
             *
             * Stack top contains the index of
             * the nearest smaller element on the left.
             */
            if (!st.isEmpty()) {

                // Store the INDEX of the Previous Smaller Element.
                result.set(i, st.peek());
            }

            /*
             * STEP 3: Push current INDEX.
             *
             * It can become the Previous Smaller Element
             * for elements appearing on its RIGHT.
             */
            st.push(i);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {4, 8, 5, 2, 25};

        ArrayList<Integer> result = previousSmallerElement(arr);

        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Previous Smaller Indexes: " + result);
    }
}
