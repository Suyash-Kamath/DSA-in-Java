import java.util.ArrayList;
import java.util.List;

public class NodesBetweenCriticalPoints {

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }

    static int[] nodesBetweenCriticalPoint(ListNode head) {

        // Need at least 3 nodes to have a critical point
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        ListNode prev = head;
        ListNode curr = head.next;

        int i = 1;

        List<Integer> criticalPoints = new ArrayList<>();

        while (curr != null && curr.next != null) {

            // Local maximum
            if (curr.data > prev.data &&
                curr.data > curr.next.data) {

                criticalPoints.add(i);
            }

            // Local minimum
            else if (curr.data < prev.data &&
                     curr.data < curr.next.data) {

                criticalPoints.add(i);
            }

            prev = curr;
            curr = curr.next;
            i++;
        }

        // At least 2 critical points are required
        if (criticalPoints.size() < 2) {
            return new int[]{-1, -1};
        }

        // Find minimum distance
        int minDist = Integer.MAX_VALUE;

        for (int j = 1; j < criticalPoints.size(); j++) {

            int distance =
                    criticalPoints.get(j)
                    - criticalPoints.get(j - 1);

            minDist = Math.min(minDist, distance);
        }

        // Maximum distance is between
        // first and last critical point
        int maxDist =
                criticalPoints.get(criticalPoints.size() - 1)
                - criticalPoints.get(0);

        return new int[]{minDist, maxDist};
    }

    static ListNode createList(int[] arr) {

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        for (int value : arr) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        /*
         * List:
         *
         * 5 -> 3 -> 1 -> 2 -> 5 -> 1 -> 2
         *
         * Critical points:
         *
         * index 2 : 1
         *           because 1 < 3 and 1 < 2
         *
         * index 4 : 5
         *           because 5 > 2 and 5 > 1
         *
         * index 5 : 1
         *           because 1 < 5 and 1 < 2
         *
         * Critical indices = [2, 4, 5]
         *
         * min distance = min(4-2, 5-4)
         *              = min(2, 1)
         *              = 1
         *
         * max distance = 5 - 2
         *              = 3
         */

        int[] arr = {5, 3, 1, 2, 5, 1, 2};

        ListNode head = createList(arr);

        int[] result = nodesBetweenCriticalPoint(head);

        System.out.println("Minimum distance: " + result[0]);
        System.out.println("Maximum distance: " + result[1]);
    }
}
