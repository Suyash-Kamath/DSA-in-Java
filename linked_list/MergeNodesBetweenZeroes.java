public class MergeNodesBetweenZeroes {

    /*
     * Problem:
     *
     * Input:
     * 0 -> 3 -> 1 -> 0 -> 4 -> 5 -> 2 -> 0
     *
     * Output:
     * 4 -> 11
     *
     * Because:
     *
     * 3 + 1 = 4
     * 4 + 5 + 2 = 11
     */


    // ---------------------------------------------------------
    // Brute Force
    // ---------------------------------------------------------
    //
    // Traverse the list.
    //
    // Whenever we encounter 0:
    //     create a new node containing the current sum
    //     insert it into the answer list
    //     reset sum = 0
    //
    // Time Complexity  : O(n)
    // Space Complexity : O(n)
    //
    // because we create new nodes.
    //


    // ---------------------------------------------------------
    // Optimal Solution
    // ---------------------------------------------------------
    //
    // We don't create any new nodes.
    //
    // read  -> traverses the original list
    // write -> writes the calculated sum into existing nodes
    //
    // Example:
    //
    // 0 -> 3 -> 1 -> 0 -> 4 -> 5 -> 2 -> 0
    //
    // After first iteration:
    //
    // write.val = 3 + 1 = 4
    //
    // After second iteration:
    //
    // write.val = 4 + 5 + 2 = 11
    //
    // Result:
    //
    // 4 -> 11
    //
    // Time Complexity  : O(n)
    // Space Complexity : O(1)
    //

    static ListNode mergeNodes(ListNode head) {

        // read is used to traverse the original list
        ListNode read = head.next;

        // write points to the node where we will
        // store the calculated sum.
        ListNode write = head;

        

        while (read != null) {

            int sum = 0;

            // Keep adding values until we find 0
            while (read != null && read.val != 0) {
                sum += read.val;
                read = read.next;
            }

            // Store the sum in the current write node
            write.val = sum;

            /*
             * read is currently pointing at 0.
             *
             * We don't want to keep this 0.
             * So connect write to the node after 0.
             */
            if (read != null) {
                write.next = read.next;
                read = read.next;
            }

            // Move write forward
            write = write.next;
        }

        return head;
    }


    // ---------------------------------------------------------
    // ListNode
    // ---------------------------------------------------------

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }


    // ---------------------------------------------------------
    // Print Linked List
    // ---------------------------------------------------------

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


    // ---------------------------------------------------------
    // Main
    // ---------------------------------------------------------

    public static void main(String[] args) {

        /*
         * Input:
         *
         * 0 -> 3 -> 1 -> 0 -> 4 -> 5 -> 2 -> 0
         */

        ListNode head = new ListNode(0);

        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(0);


        System.out.println("Original List:");
        printList(head);


        head = mergeNodes(head);


        System.out.println("After Merging:");
        printList(head);
    }
}
