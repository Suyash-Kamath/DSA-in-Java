public class CheckPalindromeLinkedList {

    static ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    static ListNode reverseLL(ListNode head) {
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

    static boolean isPalindrome(ListNode head) {

        // brute force is copy the linkedlist , reverse it and compare 

    if(head==null) return true;
    
    if(head.next==null) return true;
        // optimal approach  is 

        // step 1 : find the midpoint
        ListNode list2 = getMid(head);

        // step 2: break the list 
        ListNode temp = head;

        while (temp.next != list2) {
            temp = temp.next;
        }

        temp.next = null;

        // step 3: reverse the second list 

        ListNode head2 = reverseLL(list2);

        // step 4: compare the 2 lists

        ListNode temp1 = head;
        ListNode temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if (temp1.val != temp2.val)
                return false;
            else {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        // 10 -> 20 -> 30 -> 40 -> 50
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(20);
        head.next.next.next.next = new ListNode(10);

        boolean ans = isPalindrome(head);

        System.out.println("Is Palindrome: " + ans);
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
