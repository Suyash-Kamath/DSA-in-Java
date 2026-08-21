public class AddOneToLL {

    // Node of Linked List
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // brute forces is 999999 me last node me +1 , koi carry hai second last me jaunga ,
    // if new carry then insert at head , that is O(n^2)


    // agar n , n-1 , n-2 , aisa traversal karna hai , agar time bachta hai

    // then I can do it

    // reverse game khello abhi bro , o(n) + o(1) + o(n)

    // reverse , carry hai , aage transfer karlo , 9 ka 0 and aage +1

    // and then reverse , and 899 ka 900 hai

    static ListNode reverseList(ListNode head) {
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

    static ListNode plusOne(ListNode head) {

        // reverse original LL
        head = reverseList(head);

        // add 1 ka main logic
        ListNode curr = head;

        int carry = 1;

        while (curr != null) {

            int nodeValue = curr.val;

            int sum = nodeValue + carry;

            int digit = sum % 10;

            // insert the digit in curr node
            curr.val = digit;

            // find out if any carry to pass on
            carry = sum / 10;

            // move curr aage
            if (curr.next == null && carry > 0) {
                curr.next = new ListNode(carry);
                carry = 0;
            }

            curr = curr.next;
        }

        // reverse the LL again
        head = reverseList(head);

        // return head of modified LL
        return head;
    }


    public static void main(String[] args) {

        // 8 -> 9 -> 9
        ListNode head = new ListNode(8);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);

        head = plusOne(head);

        // print result
        ListNode curr = head;

        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
