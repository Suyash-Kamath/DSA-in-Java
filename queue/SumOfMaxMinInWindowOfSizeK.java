
import java.util.*;

public class SumOfMaxMinInWindowOfSizeK {

    public static int sumOfMinAndMax(int[] arr, int k) {

        // Validate input
        if (arr == null || k <= 0 || k > arr.length) {
            throw new IllegalArgumentException("Invalid window size");
        }

        int totalSum = 0;

        // We store INDEXES, not actual array elements.
        Deque<Integer> maxdq = new ArrayDeque<>();
        Deque<Integer> mindq = new ArrayDeque<>();

        // ==========================================
        // STEP 1: PROCESS THE FIRST WINDOW OF SIZE K
        // ==========================================

        for (int i = 0; i < k; i++) {

            // MAX DEQUE:
            // Maintain decreasing order of array values.
            // Remove all smaller elements from the back
            // because the current element is greater
            // and can replace them as a maximum candidate.

            while (!maxdq.isEmpty() &&
                   arr[maxdq.peekLast()] < arr[i]) {

                maxdq.pollLast();
            }

            // MIN DEQUE:
            // Maintain increasing order of array values.
            // Remove all greater elements from the back
            // because the current element is smaller
            // and can replace them as a minimum candidate.

            while (!mindq.isEmpty() &&
                   arr[mindq.peekLast()] > arr[i]) {

                mindq.pollLast();
            }

            // Insert the current index into both deques.
            maxdq.offerLast(i);
            mindq.offerLast(i);
        }

        // Front of maxdq contains the index of maximum.
        // Front of mindq contains the index of minimum.

        totalSum += arr[maxdq.peekFirst()]
                  + arr[mindq.peekFirst()];


        // ==========================================
        // STEP 2: PROCESS ALL REMAINING WINDOWS
        // ==========================================

        for (int i = k; i < arr.length; i++) {

            // --------------------------------------
            // 2A. REMOVE EXPIRED ELEMENTS
            // --------------------------------------

            // Current window starts at index (i - k + 1).
            // Any index <= i - k is outside the window.

            while (!maxdq.isEmpty() &&
                   maxdq.peekFirst() <= i - k) {

                maxdq.pollFirst();
            }

            while (!mindq.isEmpty() &&
                   mindq.peekFirst() <= i - k) {

                mindq.pollFirst();
            }


            // --------------------------------------
            // 2B. REMOVE IRRELEVANT ELEMENTS
            // --------------------------------------

            // MAX DEQUE:
            // Remove smaller elements from the back.

            while (!maxdq.isEmpty() &&
                   arr[maxdq.peekLast()] < arr[i]) {

                maxdq.pollLast();
            }

            // MIN DEQUE:
            // Remove greater elements from the back.

            while (!mindq.isEmpty() &&
                   arr[mindq.peekLast()] > arr[i]) {

                mindq.pollLast();
            }


            // --------------------------------------
            // 2C. ADD THE CURRENT ELEMENT
            // --------------------------------------

            maxdq.offerLast(i);
            mindq.offerLast(i);


            // --------------------------------------
            // 2D. CALCULATE ANSWER FOR THIS WINDOW
            // --------------------------------------

            // Front of maxdq = maximum element index.
            // Front of mindq = minimum element index.

            totalSum += arr[maxdq.peekFirst()]
                      + arr[mindq.peekFirst()];
        }

        return totalSum;
    }


    public static void main(String[] args) {

        int[] arr = {2, 5, -1, 7, -3, -1, -2};

        int k = 3;

        System.out.println(sumOfMinAndMax(arr, k));
    }
}
