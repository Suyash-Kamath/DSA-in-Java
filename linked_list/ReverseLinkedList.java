// public class ReverseLinkedList {

//     static ListNode reverseList(ListNode head) {
//         ListNode prev = null;
//         ListNode curr = head;

//         while (curr != null) {
//             ListNode forward = curr.next;

//             curr.next = prev;
//             prev = curr;
//             curr = forward;
//         }

//         return prev;
//     }

//     static void printList(ListNode head) {
//         ListNode curr = head;

//         while (curr != null) {
//             System.out.print(curr.val);

//             if (curr.next != null) {
//                 System.out.print(" -> ");
//             }

//             curr = curr.next;
//         }

//         System.out.println();
//     }

//     public static void main(String[] args) {

//         // Create: 1 -> 2 -> 3 -> 4 -> 5
//         ListNode head = new ListNode(1);
//         head.next = new ListNode(2);
//         head.next.next = new ListNode(3);
//         head.next.next.next = new ListNode(4);
//         head.next.next.next.next = new ListNode(5);

//         System.out.println("Original List:");
//         printList(head);

//         // Reverse the linked list
//         head = reverseList(head);

//         System.out.println("Reversed List:");
//         printList(head);
//     }
// }
// class ListNode {
//     int val;
//     ListNode next;

//     ListNode() {
//     }

//     ListNode(int x) {
//         val = x;
//     }

//     ListNode(int x, ListNode next) {
//         val = x;
//         this.next = next;
//     }
// }





public class ReverseLinkedList {

    static ListNode solve(ListNode prev, ListNode curr) {

        // Base case
        if (curr == null) {
            return prev;
        }

        // 1 case me kaam karo, baaki recursion karega

        ListNode forward = curr.next;

        curr.next = prev;

        // Move prev and curr ahead
        prev = curr;
        curr = forward;

        // Recursion
        ListNode ans = solve(prev, curr);

        return ans;
    }

    static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        ListNode ans = solve(prev, curr);

        return ans;
    }

    static void printList(ListNode head) {

        ListNode curr = head;

        while (curr != null) {

            System.out.print(curr.val);

            if (curr.next != null) {
                System.out.print(" -> ");
            }

            curr = curr.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Create: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);

        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        // Reverse the linked list
        head = reverseList(head);

        System.out.println("Reversed List:");
        printList(head);
    }
}


class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}
