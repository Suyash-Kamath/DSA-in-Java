public class DeleteNNodesAfterMNodes {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node linkDelete(Node head, int n, int m) {

        Node prev = null;
        Node curr = head;

        // ignore
        // delete
        // baar baar repeat, so loop on basis of condition

        while (curr != null) {

            // ignore
            // Move forward by m nodes
            // In other words, keep m nodes and don't delete them
            for (int i = 1; i <= m && curr != null; i++) {
                prev = curr;
                curr = curr.next;
            }

            // If curr becomes null, there are no more nodes to delete
            if (curr == null) {
                return head;
            }

            // delete
            // Assume kar liye ki n ki value hamesha 1 hi aayegi
            // prev.next = curr.next;
            // curr = curr.next;

            // Move curr forward by n nodes
            // These n nodes will effectively be deleted
            for (int i = 1; i <= n && curr != null; i++) {
                curr = curr.next;
            }

            // link re arrange
            // Connect the last kept node to the node after the deleted nodes
            prev.next = curr;
        }

        return head;
    }

    // Print Linked List
    static void printList(Node head) {

        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        // Create Linked List
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.next = new Node(10);

        System.out.println("Original Linked List:");
        printList(head);

        // Keep 2 nodes, delete next 2 nodes, repeat
        head = linkDelete(head, 2, 2);

        System.out.println("After Deletion:");
        printList(head);

        System.out.println("Start small. Ship something.");
    }
}
