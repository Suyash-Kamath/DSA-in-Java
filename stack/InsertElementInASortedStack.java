
import java.util.*;

/*
 * Insert an element into a sorted stack using recursion only.
 *
 * Assumption:
 * The stack is sorted in ascending order from top to bottom.
 *
 * Example:
 * Top    -> 1
 *          2
 *          3
 * Bottom -> 5
 *
 * Time Complexity: O(N)
 * Auxiliary Space: O(N) due to recursion.
 */

public class InsertElementInASortedStack {

    public static void sortedInsert(Stack<Integer> st, int x) {

        // Base case 1:
        // If the stack is empty, insert x.
        if (st.isEmpty()) {
            st.push(x);
            return;
        }

        // Base case 2:
        // If x can be placed above the current top,
        // insert it directly.
        int topValue = st.peek();

        if (x <= topValue) {
            st.push(x);
            return;
        }

        // One case: remove the top element temporarily.
        st.pop();

        // Recursion handles finding the correct position for x.
        sortedInsert(st, x);

        // Backtracking: restore the removed element.
        st.push(topValue);
    }

    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();

        // Push elements so that the smallest is on top.
        st.push(5);
        st.push(4);
        st.push(3);
        st.push(2);
        st.push(1);

        System.out.println("Original stack: " + st);

        int x = 3;
        sortedInsert(st, x);

        System.out.println("After inserting " + x + ": " + st);
    }
}
