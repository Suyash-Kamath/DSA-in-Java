// Brute force:
// Count how many 0s, 1s and 2s are present,
// then overwrite the node values.
//
// But if the interviewer says:
// "Don't change the node values. Rearrange the links."
// Then we use the three-list approach.

public class SortLinkedListOfZerosOnesTwos {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node sortList(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        // Dummy heads
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);

        // Tails
        Node zeroTail = zeroHead;
        Node oneTail = oneHead;
        Node twoTail = twoHead;

        Node temp = head;

        // Create three separate linked lists
        while (temp != null) {

            Node nodeToInsert = temp;

            // Move temp BEFORE modifying nodeToInsert.next
            temp = temp.next;

            // Detach current node from original list
            nodeToInsert.next = null;

            if (nodeToInsert.data == 0) {

                zeroTail.next = nodeToInsert;
                zeroTail = nodeToInsert;

            } else if (nodeToInsert.data == 1) {

                oneTail.next = nodeToInsert;
                oneTail = nodeToInsert;

            } else {

                twoTail.next = nodeToInsert;
                twoTail = nodeToInsert;
            }
        }

        // Connect:
        // 0-list -> 1-list -> 2-list

        if (oneHead.next != null) {
            zeroTail.next = oneHead.next;
        } else {
            zeroTail.next = twoHead.next;
        }

        if (twoHead.next != null) {
            oneTail.next = twoHead.next;
        }

        // Make sure final node points to null
        twoTail.next = null;

        // Remove dummy zeroHead
        return zeroHead.next;
    }

    static void printList(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data);

            if (temp.next != null) {
                System.out.print(" -> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // 1 -> 2 -> 0 -> 1 -> 2 -> 0 -> 1
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(0);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(1);

        System.out.println("Original List:");
        printList(head);

        head = sortList(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}
