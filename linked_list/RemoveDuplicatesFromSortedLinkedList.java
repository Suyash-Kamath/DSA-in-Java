public class RemoveDuplicatesFromSortedLinkedList {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode prev = head;
        ListNode current = head.next;

        while (current != null) {

            if (prev.val == current.val) {
                // Remove current
                prev.next = current.next;
            } else {
                // Move both pointers
                prev = current;
            }

            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        RemoveDuplicatesFromSortedLinkedList obj =
                new RemoveDuplicatesFromSortedLinkedList();

        head = obj.deleteDuplicates(head);

        ListNode current = head;

        while (current != null) {
            System.out.print(current.val);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
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