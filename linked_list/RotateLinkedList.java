public class RotateLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int len = 1;
        ListNode temp = head;

        // Find length and last node
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }

        // Make circular
        temp.next = head;

        // Handle k > len
        k %= len;

        // If no rotation needed
        if (k == 0) {
            temp.next = null;
            return head;
        }

        // Move to new tail
        temp = head;
        for (int i = 1; i <= len - k - 1; i++) {
            temp = temp.next;
        }

        ListNode newHead = temp.next;

        // Break the circle
        temp.next = null;

        return newHead;
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        int k = 2;

        head = rotateRight(head, k);

        System.out.println("After rotating by " + k + ":");
        printList(head);
    }
}
