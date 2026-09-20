import java.util.HashMap;
import java.util.Map;

public class DeepCopyLinkedListWithRandomPointerBruteForceMethod {

    static class Node {
        int data;
        Node next;
        Node random;

        Node(int data) {
            this.data = data;
        }
    }

    static Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        /*
         * Map:
         *
         * OLD NODE        NEW NODE
         *
         * oldNode1   ->   newNode1
         * oldNode2   ->   newNode2
         * oldNode3   ->   newNode3
         */
        Map<Node, Node> map = new HashMap<>();


        // ------------------------------------------------
        // PASS 1:
        // Create copies of all nodes
        // ------------------------------------------------

        Node curr = head;

        while (curr != null) {

            Node newNode = new Node(curr.data);

            map.put(curr, newNode);

            curr = curr.next;
        }


        // ------------------------------------------------
        // PASS 2:
        // Connect next and random pointers
        // ------------------------------------------------

        curr = head;

        while (curr != null) {

            Node copiedNode = map.get(curr);

            // Copy next pointer
            copiedNode.next = map.get(curr.next);

            // Copy random pointer
            copiedNode.random = map.get(curr.random);

            curr = curr.next;
        }


        // Return copy of original head
        return map.get(head);
    }


    public static void main(String[] args) {

        /*
         * Example:
         *
         * 1 -> 2 -> 3 -> 4
         *
         * Random pointers:
         *
         * 1.random -> 3
         * 2.random -> 1
         * 3.random -> 4
         * 4.random -> 2
         */

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        // next pointers
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        // random pointers
        n1.random = n3;
        n2.random = n1;
        n3.random = n4;
        n4.random = n2;


        Node copiedHead = copyRandomList(n1);


        Node curr = copiedHead;

        while (curr != null) {

            System.out.print(
                    "Node: " + curr.data +
                    ", Random: "
            );

            if (curr.random != null) {
                System.out.println(curr.random.data);
            } else {
                System.out.println("null");
            }

            curr = curr.next;
        }
    }
}
