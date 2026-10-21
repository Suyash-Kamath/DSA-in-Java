
import java.util.*;

// Constraints:
// 1. Use recursion.
// 2. Restore the stack to its initial state.

/*
 * Time Complexity: O(N)
 * Auxiliary Space: O(N)
 */

public class CheckStackSortedOrNot {

    public static boolean isSorted(Stack<Integer> st) {

        // Base case
        if (st.size() <= 1) {
            return true;
        }

        // Solve one case: remove the top element
        int prevElement = st.pop();

        // Get the element now at the top
        int currElement = st.peek();

        // Check ascending order from top to bottom
        boolean ekCaseKaAns = prevElement <= currElement;

        // Recursively check the remaining stack
        boolean recKaAns = isSorted(st);

        // Restore the original stack
        st.push(prevElement);

        // Combine both answers
        return ekCaseKaAns && recKaAns;
    }

    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();

        // Stack bottom to top: [5, 4, 3, 2, 1]
        st.push(5);
        st.push(4);
        st.push(3);
        st.push(2);
        st.push(1);

        System.out.println("Original stack: " + st);

        boolean ans = isSorted(st);

        System.out.println("Is stack sorted? " + ans);
        System.out.println("Restored stack: " + st);
    }
}
