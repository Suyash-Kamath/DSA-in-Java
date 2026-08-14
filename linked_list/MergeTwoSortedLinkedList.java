public class MergeTwoSortedLinkedList {

    // Brute Force is Use Hashmap

    // nice approah fast anf slow pointer

    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode ansHead = dummy;
        ListNode ansTail = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {

                ansTail.next = list1;
                list1 = list1.next;
                ansTail = ansTail.next;

            } else {

                ansTail.next = list2;
                list2 = list2.next;
                ansTail = ansTail.next;
            }
        }

        // list is fully consumed and another is left
        // if list1 is not consumed

        if (list1 != null) {
            ansTail.next = list1;
        }

        // if list2 is not consumed

        if (list2 != null) {
            ansTail.next = list2;
        }

        // ans list is fully ready , remove the dummyNode

        ansHead = ansHead.next;
        dummy.next = null;

        return ansHead;
    }

    // Print Linked List
    static void printList(ListNode head) {

        ListNode current = head;

        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        // First sorted linked list
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        list1.next.next.next = new ListNode(7);

        // Second sorted linked list
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        list2.next.next.next = new ListNode(8);

        System.out.println("List 1:");
        printList(list1);

        System.out.println("List 2:");
        printList(list2);

        // Merge both lists
        ListNode mergedList = mergeTwoLists(list1, list2);

        System.out.println("Merged List:");
        printList(mergedList);
    }
}


class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
