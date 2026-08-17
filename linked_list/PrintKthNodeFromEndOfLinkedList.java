public class PrintKthNodeFromEndOfLinkedList {
// Brute force, O(N) to find the length and then second O(N-K) length - k , to take these steps/jumps



    public static ListNode kthNodeFromEnd(ListNode head, int k) {

        ListNode previous = head;
        ListNode current = head;

        // Move fast k steps ahead
        for (int i = 0; i < k; i++) {

            if (current == null) {
                return null; // k is greater than list length
            }

            current = current.next;
        }

        // Move both pointers until fast reaches the end
        while (current != null) {
            previous = previous.next;
            current = current.next;
        }

        return previous;
    }

    public static void main(String[] args) {

        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        ListNode result = kthNodeFromEnd(head, k);

        if (result != null) {
            System.out.println("Kth node from end: " + result.val);
        } else {
            System.out.println("Invalid k");
        }
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}