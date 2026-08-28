
public class PartitionLinkedList {

    static ListNode partition(ListNode head, int x) {

        ListNode lesserHead = new ListNode(-1);
        ListNode lesserTail = lesserHead;

        ListNode greaterHead = new ListNode(-1);
        ListNode greaterTail = greaterHead;

        ListNode temp = head;

        while (temp != null) {
            if (temp.val < x) {
                // seperate this node andd apppend to lesser linkedlist and also before doing this  make sure temp points to the head of the remaining list

                ListNode nodeToInsert = temp;
                temp = temp.next;
                nodeToInsert.next = null;

                // insert at tail -> less wali LL me

                lesserTail.next = nodeToInsert;
                lesserTail = nodeToInsert;

            } else {
                ListNode nodeToInsert = temp;
                temp = temp.next;
                nodeToInsert.next = null;

                // insert at tail -> greater wali LL me

                greaterTail.next = nodeToInsert;
                greaterTail = nodeToInsert;

            }
        }

        // yahape dono sublist is ready , so join them
        // also remove the dummy nodes

        lesserTail.next = greaterHead.next;
        greaterTail.next = null;

        // remove start dummy node

        lesserHead = lesserHead.next;

        return lesserHead;
    }

    public static void main(String[] args) {

        // Create linked list: 1 -> 4 -> 3 -> 2 -> 5 -> 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        int x = 3;

        // Print original list
        System.out.println("Original Linked List:");
        printList(head);

        // Partition the linked list
        ListNode result = partition(head, x);

        // Print partitioned list
        System.out.println("After Partition around " + x + ":");
        printList(result);
    }

    static void printList(ListNode head) {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val);

            if (temp.next != null) {
                System.out.print(" -> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }
}
