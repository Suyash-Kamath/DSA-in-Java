public class DeepCopyLinkedListWithRandomPointerUsingInterleavingMethod {

    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }
    }

    /*
        Step 1:
        Clone nodes and interleave them.

        Old:
        1 -> 2 -> 3

        After interleaving:
        1 -> 1' -> 2 -> 2' -> 3 -> 3'


        Step 2:
        Copy random pointers.

        Observation:

        oldNode.random = old 7

        oldNode.random.next = cloned 7

        Therefore:

        newNode.random = oldNode.random.next


        Step 3:
        Detach original and cloned lists.
    */

    static Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }


        // ==================================================
        // STEP 1: Interleave cloned nodes
        // ==================================================

        Node temp = head;

        while (temp != null) {

            Node cloneNode = new Node(temp.val);

            // clone points to old next
            cloneNode.next = temp.next;

            // old node points to clone
            temp.next = cloneNode;

            // move to next original node
            temp = cloneNode.next;
        }


        /*
            Example:

            Before:

            1 -> 2 -> 3 -> 4


            After Step 1:

            1 -> 1' -> 2 -> 2' -> 3 -> 3' -> 4 -> 4'
        */


        // ==================================================
        // STEP 2: Copy random pointers
        // ==================================================

        temp = head;

        while (temp != null) {

            Node oldNode = temp;
            Node newNode = temp.next;


            /*
                Suppose:

                oldNode.random ---> old 7


                Since cloned 7 is immediately after old 7:

                oldNode.random.next ---> cloned 7


                Therefore:
            */

            if (oldNode.random != null) {
                newNode.random = oldNode.random.next;
            }


            // move to next ORIGINAL node
            temp = newNode.next;
        }


        // ==================================================
        // STEP 3: Detach both lists
        // ==================================================

        temp = head;

        Node ansListHead = head.next;

        while (temp != null) {

            Node oldNode = temp;
            Node cloneNode = temp.next;


            // Restore original list
            oldNode.next = cloneNode.next;


            // Connect cloned list
            if (cloneNode.next != null) {
                cloneNode.next = cloneNode.next.next;
            }


            // Move to next original node
            temp = oldNode.next;
        }


        return ansListHead;
    }


    static void printList(Node head) {

        Node temp = head;

        while (temp != null) {

            System.out.print(
                    "Node: " + temp.val +
                    ", Random: "
            );

            if (temp.random != null) {
                System.out.println(temp.random.val);
            } else {
                System.out.println("null");
            }

            temp = temp.next;
        }
    }


    public static void main(String[] args) {

        /*
            1 -> 2 -> 3 -> 4

            Random:
            1 -> 3
            2 -> 1
            3 -> 4
            4 -> 2
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


        System.out.println("Original list:");
        printList(n1);

        System.out.println();

        System.out.println("Copied list:");
        printList(copiedHead);
    }
}
