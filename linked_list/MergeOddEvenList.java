public class MergeOddEvenList {

    /*
     * Problem:
     * Rearrange the linked list so that:
     *
     * 1 -> 2 -> 3 -> 4 -> 5
     *
     * becomes:
     *
     * 1 -> 3 -> 5 -> 2 -> 4
     *
     * Important:
     * "Odd" and "Even" refer to POSITION, not the value.
     *
     * Brute Force:
     * Create a new linked list and first add nodes at odd positions,
     * then add nodes at even positions.
     *
     * Optimal:
     * Rearrange the existing links.
     * Time  : O(n)
     * Space : O(1)
     */

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode oddEvenList(ListNode head) {

        // Empty list
        if (head == null) {
            return null;
        }

        // Only one node
        if (head.next == null) {
            return head;
        }

        // Odd-position list
        ListNode oddHead = head;
        ListNode oddTail = head;

        // Even-position list
        ListNode evenHead = head.next;
        ListNode evenTail = head.next;

        /*
         * We maintain two chains:
         *
         * Odd:
         * 1 -> 3 -> 5
         *
         * Even:
         * 2 -> 4 -> 6
         *
         * Finally:
         * Odd chain -> Even chain
         */
        while (evenTail != null && evenTail.next != null) {

            // Connect current odd node to next odd node
            oddTail.next = evenTail.next;
            oddTail = oddTail.next;

            // Connect current even node to next even node
            evenTail.next = oddTail.next;
            evenTail = evenTail.next;
        }

        // Attach even list after odd list
        oddTail.next = evenHead;

        return oddHead;
    }

    static void printList(ListNode head) {

        ListNode current = head;

        while (current != null) {
            System.out.print(current.val);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        /*
         * Create:
         *
         * 1 -> 2 -> 3 -> 4 -> 5
         */
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        head = oddEvenList(head);

        System.out.println("After Odd-Even Rearrangement:");
        printList(head);
    }
}
