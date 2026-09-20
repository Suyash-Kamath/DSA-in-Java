public class DoubleLinkedListIntegerRepresentation {

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }


    // ============================================
    // Reverse Linked List
    // ============================================

    static ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode forward = curr.next;

            curr.next = prev;

            prev = curr;
            curr = forward;
        }

        return prev;
    }


    // ============================================
    // Double the number represented by Linked List
    // ============================================

    static ListNode doubleList(ListNode head) {

        if (head == null) {
            return null;
        }


        // ========================================
        // STEP 1: Reverse linked list
        // ========================================

        head = reverse(head);


        /*
            Example:

            Original number:

            1 -> 8 -> 9

            represents:

            189

            After reverse:

            9 -> 8 -> 1

            Now multiplication becomes easy because
            we start from the last digit.
        */


        // ========================================
        // STEP 2: Perform multiplication
        // ========================================

        ListNode dummy = new ListNode(-1);

        ListNode curr = dummy;
        ListNode temp = head;

        int carry = 0;


        while (temp != null) {

            int value = temp.data;

            int sum = value + value + carry;

            int digit = sum % 10;

            carry = sum / 10;


            // Add digit to answer linked list
            curr.next = new ListNode(digit);

            curr = curr.next;


            // VERY IMPORTANT:
            // move temp forward
            temp = temp.next;
        }


        // ========================================
        // Handle remaining carry
        // ========================================

        if (carry != 0) {
            curr.next = new ListNode(carry);
        }


        // ========================================
        // Remove dummy node
        // ========================================

        ListNode answer = dummy.next;


        // ========================================
        // STEP 3: Reverse answer
        // ========================================

        answer = reverse(answer);


        return answer;
    }


    // ============================================
    // Helper: Create Linked List
    // ============================================

    static ListNode createList(int[] arr) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for (int value : arr) {

            curr.next = new ListNode(value);

            curr = curr.next;
        }

        return dummy.next;
    }


    // ============================================
    // Helper: Print Linked List
    // ============================================

    static void printList(ListNode head) {

        ListNode temp = head;

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

        /*
            Number = 189

            Linked List:

            1 -> 8 -> 9

            Double:

            189 × 2 = 378

            Answer:

            3 -> 7 -> 8
        */

        int[] arr = {1, 8, 9};

        ListNode head = createList(arr);


        System.out.println("Original Number:");

        printList(head);


        ListNode answer = doubleList(head);


        System.out.println("After Doubling:");

        printList(answer);
    }
}
