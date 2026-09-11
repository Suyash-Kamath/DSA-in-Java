public class ReverseLinkedListInGroupOfKExcludingGroupIfLessThanK {

    // ListNode class
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static ListNode reverseKGroup(ListNode head, int k) {

        // check length of LinkedList and act accordingly
        int len = 0;
        ListNode temp = head;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        // If remaining group has less than k nodes,
        // don't reverse it
        if (len < k) {
            return head;
        }

        // first k len group ko reverse karna hai
        ListNode prev = null;
        ListNode curr = head;

        for (int i = 1; i <= k; i++) {

            ListNode forward = curr.next;

            curr.next = prev;

            prev = curr;

            curr = forward;
        }

        // remaining list ko recursion se solve
        ListNode recursionKaAnsKaHead = reverseKGroup(curr, k);

        // join both list
        head.next = recursionKaAnsKaHead;

        // LL is reversed as per question demand
        return prev;
    }

    // Linked List print karne ke liye
    static void printList(ListNode head) {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        System.out.println("Start small. Ship something.");

        // Creating Linked List
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> NULL

        ListNode head = new ListNode(1);

        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);

        System.out.println("Original Linked List:");
        printList(head);

        int k = 3;

        ListNode ans = reverseKGroup(head, k);

        System.out.println("After reversing in groups of " + k + ":");
        printList(ans);
    }
}
