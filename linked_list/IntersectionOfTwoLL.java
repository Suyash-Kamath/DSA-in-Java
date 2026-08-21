public class IntersectionOfTwoLL {

    // Approach: length-difference
    // 1. Walk both lists together until one runs out
    // 2. Whatever is left on the other pointer = the extra length
    // 3. Advance the longer list's head by that amount
    // 4. Now both are equidistant from the tail -> move together until they meet

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;   // nothing can be common
        }

        ListNode a = headA;
        ListNode b = headB;

        // both advance min(lenA, lenB) steps
        while (a != null && b != null) {
            a = a.next;
            b = b.next;
        }

        // start pointers, aligned below so both have equal distance to the tail
        ListNode p = headA;
        ListNode q = headB;

        if (a == null) {
            // list B is longer (or equal) - remaining nodes on b = the difference
            int bExtraLen = 0;
            while (b != null) {
                bExtraLen++;
                b = b.next;
            }
            while (bExtraLen-- > 0) {
                q = q.next;
            }
        } else {
            // list A is longer
            int aExtraLen = 0;
            while (a != null) {
                aExtraLen++;
                a = a.next;
            }
            while (aExtraLen-- > 0) {
                p = p.next;
            }
        }

        // p and q are now the same number of nodes away from the end
        while (p != null && q != null) {
            if (p == q) {
                return p;
            }
            p = p.next;
            q = q.next;
        }

        return null;
    }

    public static void main(String[] args) {

        /*
         * List A:
         *
         * 1 -> 2 -> 3
         *           \
         *            7 -> 8
         *           /
         * List B:  4 -> 5
         *
         * Intersection = 7
         */

        ListNode common = new ListNode(7);
        common.next = new ListNode(8);

        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = common;

        ListNode headB = new ListNode(4);
        headB.next = new ListNode(5);
        headB.next.next = common;

        printResult(getIntersectionNode(headA, headB));   // expects 7

        // Case 2: no intersection
        ListNode x = new ListNode(1);
        x.next = new ListNode(2);

        ListNode y = new ListNode(3);
        y.next = new ListNode(4);

        printResult(getIntersectionNode(x, y));           // expects "No Intersection"
    }

    static void printResult(ListNode node) {
        if (node != null) {
            System.out.println("Intersection Node: " + node.val);
        } else {
            System.out.println("No Intersection");
        }
    }
}
