
import java.util.*;

public class NextGreaterElementStoreIndex {

    public static ArrayList<Integer> nextGreaterElement(int[] arr) {

        int n = arr.length;

        ArrayList<Integer> result = new ArrayList<>();

        // Initially, assume no Next Greater Element exists.
        // -1 means no greater element is available on the right.
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
             * arr[st.peek()] gives the actual value.
             *
             * We need a STRICTLY greater element.
             * Therefore, remove elements <= curr.
             */
            while (!st.isEmpty() && arr[st.peek()] <= curr) {
                st.pop();
            }

            /*
             * STEP 2: Find Next Greater Element.
             *
             * If stack is not empty:
             * Its top contains the index of the
             * nearest greater element on the right.
             */
            if (!st.isEmpty()) {
                result.set(i, st.peek());
            }

            /*
             * STEP 3: Push current index.
             *
             * Current element can become the Next Greater
             * Element for elements appearing on its LEFT.
             */
            st.push(i);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {4, 8, 5, 2, 25};

        ArrayList<Integer> result = nextGreaterElement(arr);

        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Next Greater Indexes: " + result);
    }
}
