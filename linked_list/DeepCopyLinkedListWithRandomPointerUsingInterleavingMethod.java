public class DeepCopyLinkedListWithRandomPointerUsingInterleavingMethod {

    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }
    }

    static Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        // ==================================================
        // STEP 1: Create clone nodes and interleave
        // ==================================================

        Node temp = head;

        while (temp != null) {

            Node cloneNode = new Node(temp.val);

            cloneNode.next = temp.next;
            temp.next = cloneNode;

            temp = cloneNode.next;
        }

        /*
            After step 1:

            7 -> 7' -> 13 -> 13' -> 11 -> 11'
              -> 10 -> 10' -> 1 -> 1'
        */


        // ==================================================
        // STEP 2: Copy random pointers
        // ==================================================

        temp = head;

        while (temp != null) {

            Node oldNode = temp;
            Node newNode = temp.next;

            if (oldNode.random != null) {
                newNode.random = oldNode.random.next;
            }

            temp = newNode.next;
        }


        // ==================================================
        // STEP 3: Detach original and cloned list
        // ==================================================

        Node ansListHead = head.next;

        temp = head;

        while (temp != null) {

            Node oldNode = temp;
            Node cloneNode = temp.next;

            // restore original list
            oldNode.next = cloneNode.next;

            // connect cloned list
            if (cloneNode.next != null) {
                cloneNode.next = cloneNode.next.next;
            }

            temp = oldNode.next;
        }

        return ansListHead;
    }


    static void printList(Node head) {

        Node temp = head;

        while (temp != null) {

            System.out.print(
                    "Node = " + temp.val +
                    ", Random = "
            );

            if (temp.random == null) {
                System.out.println("null");
            } else {
                System.out.println(temp.random.val);
            }

            temp = temp.next;
        }
    }


    public static void main(String[] args) {

        // ============================================
        // CREATE NODES FROM YOUR DIAGRAM
        // ============================================

        Node n7 = new Node(7);
        Node n13 = new Node(13);
        Node n11 = new Node(11);
        Node n10 = new Node(10);
        Node n1 = new Node(1);


        // ============================================
        // NEXT POINTERS
        //
        // 7 -> 13 -> 11 -> 10 -> 1 -> null
        // ============================================

        n7.next = n13;
        n13.next = n11;
        n11.next = n10;
        n10.next = n1;


        // ============================================
        // RANDOM POINTERS
        // ============================================

        n7.random = null;

        // 13 -> 7
        n13.random = n7;

        // 11 -> 1
        n11.random = n1;

        // 10 -> 11
        n10.random = n11;

        // 1 -> 7
        n1.random = n7;


        Node head = n7;


        System.out.println("Original List:");
        printList(head);


        // Deep Copy
        Node copiedHead = copyRandomList(head);


        System.out.println("\nOriginal List after copying:");
        printList(head);

        System.out.println("\nDeep Copied List:");
        printList(copiedHead);
    }
}
