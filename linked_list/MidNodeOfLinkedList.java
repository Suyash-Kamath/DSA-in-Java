public class MidNodeOfLinkedList {

    static ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // while (fast != null && fast.next != null) {
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }

        while(fast!=null){
            fast=fast.next;
            if(fast!=null){
                fast=fast.next;
            }
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        // 10 -> 20 -> 30 -> 40 -> 50
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);

        ListNode middle = middleNode(head);

        System.out.println("Middle node: " + middle.val);
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
}
