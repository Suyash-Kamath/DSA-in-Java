// Online Java Compiler
// Use this editor to write, compile, and run your Java code online.

public class SplitLinkedListIntoParts {

    // Definition of a singly linked-list node.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode[] splitListToParts(ListNode head, int k) {

        // This array will store the head node of each resulting linked-list part.
        ListNode[] ans = new ListNode[k];

        // Find the total length of the linked list.
        ListNode temp = head;
        int len = 0;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        /*
         * Every part will contain at least baseSize nodes.
         *
         * Example:
         * len = 10 and k = 3
         * baseSize = 10 / 3 = 3
         */
        int baseSize = len / k;

        /*
         * These extra nodes must be distributed among the first few parts.
         *
         * Example:
         * len = 10 and k = 3
         * extraNodes = 10 % 3 = 1
         *
         * Therefore, the part sizes will be:
         * 4, 3, 3
         */
        int extraNodes = len % k;

        ListNode prev = null;
        ListNode curr = head;

        /*
         * We could use while (curr != null), but instead of checking curr != null,
         * we run the loop exactly k times because we must create exactly k parts.
         *
         * If k is greater than the number of nodes, the remaining parts will be null.
         */
        for (int part = 0; part < k; part++) {

            // This is the important thinking point: every array position must represent one part.
            if (curr == null) {
                ans[part] = null;
                continue;
            }

            System.out.println("Current part starts with: " + curr.val);

            // Insert the current node into the answer array as the head of this part.
            ans[part] = curr;

            /*
             * Find the width (number of nodes) of the current sublist.
             *
             * The first extraNodes parts receive one additional node.
             */
            int width = baseSize + (extraNodes > 0 ? 1 : 0);

            // Decrement extraNodes only when an extra node was assigned to this part.
            if (extraNodes > 0) {
                extraNodes--;
            }

            System.out.println("Width of the current part: " + width);

            /*
             * Move curr by exactly 'width' nodes.
             *
             * After this loop:
             * - prev points to the final node of the current part.
             * - curr points to the first node of the next part.
             */
            for (int i = 0; i < width; i++) {
                prev = curr;
                curr = curr.next;
            }

            // Disconnect the current part from the remaining linked list.
            prev.next = null;

            // Now we move to the next iteration to construct the next part.
            prev = null;
        }

        return ans;
    }

    // Prints all the resulting linked-list parts.
    static void printParts(ListNode[] parts) {
        for (int i = 0; i < parts.length; i++) {
            System.out.print("Part " + (i + 1) + ": ");

            ListNode temp = parts[i];

            if (temp == null) {
                System.out.println("null");
                continue;
            }

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

    public static void main(String[] args) {

        // Create the linked list:
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);

        int k = 3;

        SplitLinkedListIntoParts solution = new SplitLinkedListIntoParts();
        ListNode[] answer = solution.splitListToParts(head, k);

        // Print every part after splitting the original linked list.
        printParts(answer);
    }
}
