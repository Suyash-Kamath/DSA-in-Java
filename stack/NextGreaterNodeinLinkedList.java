
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NextGreaterNodeinLinkedList {

    /*
     * APPROACH: MONOTONIC STACK — O(N) TOTAL TIME
     *
     * PROBLEM:
     * For every node, find the first greater value to its right.
     * If no greater value exists, the answer is 0.
     *
     * WHY NOT BRUTE FORCE?
     * For every node, we could traverse all the nodes after it
     * until we find a greater value.
     *
     * In the worst case, we examine many of the same nodes
     * repeatedly, resulting in O(N^2) time.
     *
     * OUR APPROACH:
     *
     * STEP 1: Convert the linked list into an ArrayList.
     * This lets us access values using their indices.
     *
     * STEP 2: Maintain a monotonic stack of INDICES.
     *
     * Each index in the stack represents a node whose
     * next greater value has not been found yet.
     *
     * STEP 3: Traverse the array from left to right.
     *
     * Whenever the current value is greater than the value
     * at the index on top of the stack:
     *
     * 1. The current value is the next greater element
     *    for that previous index.
     * 2. Store the current value in the answer array.
     * 3. Pop that index because its answer is now known.
     *
     * Continue popping while the current value is greater
     * than the values represented by the stack's indices.
     *
     * STEP 4: Push the current index onto the stack.
     *
     * Any indices remaining in the stack at the end have
     * no greater element to their right, so their answers
     * remain 0.
     *
     * WHY IS THIS O(N)?
     * Each index is pushed onto the stack exactly once
     * and popped at most once.
     *
     * Even though the while loop can run many times during
     * one iteration, the total number of pops across the
     * entire traversal cannot exceed N.
     *
     * Therefore:
     * Total time = O(N)
     * Auxiliary space = O(N)
     */

    public static int[] nextLargerNodes(ListNode head) {

        // STEP 1: Convert the linked list into an array-like list.
        List<Integer> list = new ArrayList<>();

        ListNode temp = head;

        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        int n = list.size();

        // Java initializes every element to 0.
        // This is exactly what we need when no greater value exists.
        int[] ans = new int[n];

        // Stores indices of elements whose next greater value
        // has not been found yet.
        Deque<Integer> st = new ArrayDeque<>();

        // STEP 2: Traverse each element from left to right.
        for (int i = 0; i < n; i++) {

            int currentValue = list.get(i);

            // If the current value is greater than the value
            // represented by the top index, we have found
            // the next greater element for that previous index.
            while (!st.isEmpty()
                    && currentValue > list.get(st.peek())) {

                // Retrieve the index whose answer we just found.
                int previousIndex = st.pop();

                // Store the current value as its next greater value.
                ans[previousIndex] = currentValue;
            }

            // The current index may find its next greater value
            // later, so push it onto the stack.
            st.push(i);
        }

        // Remaining indices have no greater element to their right.
        // Their answers correctly remain 0.
        return ans;
    }

    public static void main(String[] args) {

        // Example:
        // Linked list: 2 -> 1 -> 5
        // Expected answer: [5, 5, 0]

        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);

        int[] ans = nextLargerNodes(head);

        for (int value : ans) {
            System.out.print(value + " ");
        }
        // Output: 5 5 0
    }

    // Simple linked-list node definition.
    // Remove this class if your platform already provides ListNode.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
