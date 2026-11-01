
import java.util.*;

public class PreviousGreaterElementStoreIndex {

    public static ArrayList<Integer> previousGreaterElement(int[] arr) {

        int n = arr.length;

        ArrayList<Integer> result = new ArrayList<>();

        // Initially, assume no Previous Greater Element exists.
        // -1 means no greater element is available on the left.
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
             * STEP 2: Find Previous Greater Element.
             *
             * If stack is not empty:
             * Its top contains the index of the
             * nearest greater element on the left.
             */
            if (!st.isEmpty()) {
                result.set(i, st.peek());
            }

            /*
             * STEP 3: Push current index.
             *
             * Current element can become the Previous Greater
             * Element for elements appearing on its RIGHT.
             */
            st.push(i);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {4, 8, 5, 2, 25};

        ArrayList<Integer> result = previousGreaterElement(arr);

        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Previous Greater Indexes: " + result);
    }
}
