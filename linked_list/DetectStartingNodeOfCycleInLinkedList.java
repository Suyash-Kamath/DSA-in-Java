public class DetectStartingNodeOfCycleInLinkedList {

    // Brute force approach is that , it is simple , detect cycle and start node of loop using map

    // optimal approach , x=kz-y approach
    static ListNode detectCycle(ListNode head){

        // detect the cycle 

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        while(fast != null){
            fast = fast.next;

            if(fast != null){
                fast = fast.next;
                slow = slow.next;
            }

            if(fast == slow){
                hasCycle = true;
                break;
            }
        }

        if(hasCycle == false){
            return null;
        }

        // start node detect

        slow = head;

        while(fast != slow){
            slow = slow.next;
            fast = fast.next;
        }

        // abhi loop ke bahar kabhi ayenge jabhi slow == fast hoga 
        ListNode startNode = slow;

        return startNode;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }


    public static void main(String[] args) {

        /*
             1 -> 2 -> 3 -> 4 -> 5
                       ^         |
                       |_________|

             Cycle starts at node 3
        */

        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // creating cycle
        fifth.next = third;

        ListNode startNode = detectCycle(head);

        if(startNode != null){
            System.out.println("Cycle starts at node: " + startNode.val);
        }
        else{
            System.out.println("No cycle found");
        }
    }
}
