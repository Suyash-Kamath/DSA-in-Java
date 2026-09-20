public class FlattenMultilevelDoublyLinkedList {

    static class Node {
        int val;
        Node prev;
        Node next;
        Node child;

        Node(int val) {
            this.val = val;
        }
    }

    static Node flatten(Node head) {

        if (head == null) {
            return null;
        }

        Node p = head;

        while (p != null) {

            // No child, simply move forward
            if (p.child == null) {
                p = p.next;
            } else {

                // p has a child list
                Node temp = p.child;

                // Find the last node of the child list
                while (temp.next != null) {
                    temp = temp.next;
                }

                /*
                 * Current structure:
                 *
                 * p -> next
                 * |
                 * child -> ... -> temp
                 *
                 * We want:
                 *
                 * p -> child -> ... -> temp -> old next
                 */

                // Connect child list's tail to p.next
                temp.next = p.next;

                if (p.next != null) {
                    p.next.prev = temp;
                }

                // Connect p with its child
                p.next = p.child;
                p.child.prev = p;

                // Remove child reference
                p.child = null;
            }
        }

        return head;
    }

    static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.val);

            if (current.next != null) {
                System.out.print(" <-> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        /*
         * Example:
         *
         * 1 <-> 2 <-> 3 <-> 4
         *           |
         *           7 <-> 8 <-> 9
         *                 |
         *                 11 <-> 12
         *
         * Expected:
         *
         * 1 <-> 2 <-> 3 <-> 7 <-> 8 <-> 11 <-> 12 <-> 9 <-> 4
         */

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.next = n2;
        n2.prev = n1;

        n2.next = n3;
        n3.prev = n2;

        n3.next = n4;
        n4.prev = n3;


        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);

        n7.next = n8;
        n8.prev = n7;

        n8.next = n9;
        n9.prev = n8;

        // 3 has child 7
        n3.child = n7;


        Node n11 = new Node(11);
        Node n12 = new Node(12);

        n11.next = n12;
        n12.prev = n11;

        // 8 has child 11
        n8.child = n11;


        System.out.println("Before flattening:");
        System.out.println("Main list: 1 <-> 2 <-> 3 <-> 4");

        Node flattenedHead = flatten(n1);

        System.out.println("\nAfter flattening:");
        printList(flattenedHead);
    }
}
