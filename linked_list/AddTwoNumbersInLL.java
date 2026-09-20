public class AddTwoNumbersInLL {

    // same as add 1 to a number where we reverse the list , add and then reverse
    // here sirf add kardenaa

    // list1=value or list2 = value or carry!=0
    // sum digit node add carry
    // this is the loop condition

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;

        // dummy node // ans LL
        ListNode ansHead = new ListNode(-1);
        ListNode ansTail = ansHead;

        while (l1 != null || l2 != null || carry != 0) {

            int sum = 0;

            if (l1 != null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }

            // add carry to the sum
            sum = sum + carry;

            // get the digit that will be stored in the node
            int digit = sum % 10;

            // create new node
            ListNode newNode = new ListNode(digit);

            // attach new node to answer Linked List
            ansTail.next = newNode;
            ansTail = newNode;

            // calculate carry for next iteration
            carry = sum / 10;
        }

        // remove dummy node
        ansHead = ansHead.next;

        return ansHead;
    }

    // Print Linked List
    static void printList(ListNode head) {

        ListNode curr = head;

        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        // 342
        // Linked List representation: 2 -> 4 -> 3

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // 465
        // Linked List representation: 5 -> 6 -> 4

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println("List 1:");
        printList(l1);

        System.out.println("List 2:");
        printList(l2);

        ListNode result = addTwoNumbers(l1, l2);

        System.out.println("Result:");
        printList(result);

        System.out.println("Start small. Ship something.");
    }
}
