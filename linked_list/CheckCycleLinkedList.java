public class CheckCycleLinkedList {

    // Brute Force is Use Hashmap

    // nice approah fast anf slow pointer

    static boolean hasCycle(ListNode head){

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(10);

        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);

        System.out.println(hasCycle(head));
    }
}


class ListNode{

    int val;
    ListNode next;

    ListNode(int x){
        val = x;
        next = null;
    }
}
