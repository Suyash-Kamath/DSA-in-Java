
import java.util.*;

public class PreviousGreaterElement {

    public static ArrayList<Integer> previousGreaterElement(int[] arr) {

        int n = arr.length;

        ArrayList<Integer> result = new ArrayList<>();

        // Initially, assume no Previous Greater Element exists.
        for (int i = 0; i < n; i++) {
            result.add(-1);
        }

        // Monotonic Decreasing Stack.
        // Stores actual element values.
        Deque<Integer> st = new ArrayDeque<>();

        // Traverse from LEFT to RIGHT.
        for (int i = 0; i < n; i++) {

            int curr = arr[i];

            /*
             * STEP 1: Remove useless elements.
             *
             * We need a STRICTLY greater element.
             *
             * Elements smaller than or equal to curr
             * cannot be our answer.
             */
            while (!st.isEmpty() && st.peek() <= curr) {
                st.pop();
            }

            /*
             * STEP 2: Find Previous Greater Element.
             *
             * If stack is not empty, its top is
             * the nearest greater element on the left.
             */
            if (!st.isEmpty()) {
                result.set(i, st.peek());
            }

            /*
             * STEP 3: Push current element.
             *
             * It can become the Previous Greater Element
             * for elements appearing on its RIGHT.
             */
            st.push(curr);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {4, 8, 5, 2, 25};

        ArrayList<Integer> result = previousGreaterElement(arr);

        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Previous Greater: " + result);
    }
}
