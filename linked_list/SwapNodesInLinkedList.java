public class SwapNodesInLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode swapNodes(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        ListNode first = head;

        // Move to kth node from start
        for (int i = 1; i <= k - 1; i++) {
            first = first.next;
        }

        // Find kth node from end
        ListNode runner = first.next;
        ListNode second = head;

        while (runner != null) {
            runner = runner.next;
            second = second.next;
        }

        // Swap values
        int tempValue = first.val;
        first.val = second.val;
        second.val = tempValue;

        return head;
    }

    // Helper method to print list
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Before Swap:");
        printList(head);

        SwapNodesInLinkedList obj = new SwapNodesInLinkedList();
        head = obj.swapNodes(head, 2);

        System.out.println("After Swap:");
        printList(head);
    }
}
