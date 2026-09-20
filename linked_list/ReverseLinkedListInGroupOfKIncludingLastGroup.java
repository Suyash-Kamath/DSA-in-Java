public class ReverseLinkedListInGroupOfKIncludingLastGroup {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static ListNode reverseKGroup(ListNode head, int k) {

        // Base case
        if (head == null) {
            return null;
        }

        // First k nodes ko reverse karna hai
        ListNode prev = null;
        ListNode curr = head;

        for (int i = 1; i <= k && curr != null; i++) {

            ListNode forward = curr.next;

            curr.next = prev;

            prev = curr;

            curr = forward;
        }

        // Remaining list ko recursion se solve
        ListNode recursionKaAnsKaHead = reverseKGroup(curr, k);

        // Join both lists
        head.next = recursionKaAnsKaHead;

        // Reversed group ka head return
        return prev;
    }

    static void printList(ListNode head) {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9

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

        int k = 4;

        ListNode ans = reverseKGroup(head, k);

        System.out.println("After reversing in groups of " + k + ":");
        printList(ans);
    }
}
