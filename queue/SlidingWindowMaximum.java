
import java.util.*;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        // Store INDEXES, not actual values.
        // This helps us identify whether an element is outside
        // the current sliding window.
        Deque<Integer> dq = new ArrayDeque<>();

        int n = nums.length;

        // Number of sliding windows = n - k + 1
        int[] ans = new int[n - k + 1];

        int ansIndex = 0;

        // ==========================================
        // STEP 1: PROCESS THE FIRST WINDOW (0 to k-1)
        // ==========================================

        for (int i = 0; i < k; i++) {

            int element = nums[i];

            // Maintain a decreasing monotonic deque.
            //
            // Check from RIGHT to LEFT:
            // If the last element is smaller than the
            // current element, remove it.
            //
            // Why?
            // The current element is greater and comes later.
            // Therefore, the smaller element can never become
            // the maximum in any future window containing
            // the current element.
            while (!dq.isEmpty() &&
                   nums[dq.peekLast()] < element) {

                dq.pollLast();
            }

            // Insert the current element's INDEX.
            dq.offerLast(i);
        }

        // The first window is now completely processed.
        // The maximum is always at the FRONT of the deque.
        ans[ansIndex] = nums[dq.peekFirst()];
        ansIndex++;


        // ==========================================
        // STEP 2: PROCESS THE REMAINING WINDOWS
        // ==========================================

        for (int i = k; i < n; i++) {

            // --------------------------------------
            // A. REMOVE ELEMENTS OUTSIDE THE WINDOW
            // --------------------------------------

            // Current window starts at index (i - k + 1).
            // Therefore, any index <= (i - k) is out of window.
            //
            // Remove expired indexes from the FRONT.
            while (!dq.isEmpty() &&
                   dq.peekFirst() <= i - k) {

                dq.pollFirst();
            }


            // --------------------------------------
            // B. ADD THE CURRENT ELEMENT
            // --------------------------------------

            // Maintain the decreasing order again.
            //
            // Remove smaller elements from the RIGHT
            // because the current element dominates them.
            while (!dq.isEmpty() &&
                   nums[dq.peekLast()] < nums[i]) {

                dq.pollLast();
            }

            // Insert the current element's INDEX.
            dq.offerLast(i);


            // --------------------------------------
            // C. STORE THE MAXIMUM OF THIS WINDOW
            // --------------------------------------

            // The FRONT always contains the index of
            // the maximum element in the current window.
            ans[ansIndex] = nums[dq.peekFirst()];
            ansIndex++;
        }

        return ans;
    }


    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = maxSlidingWindow(nums, k);

        System.out.println(Arrays.toString(result));
    }
}
