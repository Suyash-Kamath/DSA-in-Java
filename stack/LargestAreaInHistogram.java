
import java.util.*;

public class LargestAreaInHistogram {

    /*
     * FUNCTION 1: Find Previous Smaller Element INDEX.
     *
     * For every index i:
     * Find the nearest index on the LEFT whose
     * element is STRICTLY smaller than arr[i].
     *
     * If no smaller element exists:
     * prev[i] = -1
     *
     * Traversal: LEFT TO RIGHT
     */
    public static void findPreviousSmallerIndex(int[] arr, int[] prev) {

        Deque<Integer> st = new ArrayDeque<>();

        int n = arr.length;

        for (int i = 0; i < n; i++) {

            int currIndex = i;

            /*
             * Remove useless elements.
             *
             * We need a STRICTLY smaller element.
             *
             * Therefore, pop all elements >= current element.
             *
             * Stack stores INDEXES, so compare using:
             * arr[st.peek()]
             */
            while (!st.isEmpty() && arr[st.peek()] >= arr[currIndex]) {
                st.pop();
            }

            /*
             * Stack empty:
             * No smaller element exists on the left.
             * Store -1 as the left boundary.
             *
             * Stack not empty:
             * Stack top is the Previous Smaller Index.
             */
            if (st.isEmpty()) {
                prev[i] = -1;
            } else {
                prev[i] = st.peek();
            }

            // Push current index for upcoming elements.
            st.push(currIndex);
        }
    }


    /*
     * FUNCTION 2: Find Next Smaller Element INDEX.
     *
     * For every index i:
     * Find the nearest index on the RIGHT whose
     * element is STRICTLY smaller than arr[i].
     *
     * If no smaller element exists:
     * next[i] = n
     *
     * Traversal: RIGHT TO LEFT
     */
    public static void findNextSmallerIndex(int[] arr, int[] next) {

        Deque<Integer> st = new ArrayDeque<>();

        int n = arr.length;

        for (int i = n - 1; i >= 0; i--) {

            int currIndex = i;

            /*
             * Remove useless elements.
             *
             * We need a STRICTLY smaller element.
             *
             * Therefore, pop all elements >= current element.
             */
            while (!st.isEmpty() && arr[st.peek()] >= arr[currIndex]) {
                st.pop();
            }

            /*
             * Stack empty:
             * No smaller element exists on the right.
             * Store n as the right boundary.
             *
             * Stack not empty:
             * Stack top is the Next Smaller Index.
             */
            if (st.isEmpty()) {
                next[i] = n;
            } else {
                next[i] = st.peek();
            }

            // Push current index for upcoming elements.
            st.push(currIndex);
        }
    }


    /*
     * FUNCTION 3: Calculate Largest Rectangle Area.
     *
     * Approach:
     *
     * 1. Find Previous Smaller Index for every bar.
     * 2. Find Next Smaller Index for every bar.
     * 3. Calculate width using both boundaries.
     * 4. Calculate area for every bar.
     * 5. Return the maximum area.
     */
    public static int getMaxArea(int[] arr) {

        int n = arr.length;

        // Edge case: Empty histogram.
        if (n == 0) {
            return 0;
        }

        // These two arrays store boundary INDEXES.
        int[] prev = new int[n];
        int[] next = new int[n];

        // Calculate left and right boundaries.
        findPreviousSmallerIndex(arr, prev);
        findNextSmallerIndex(arr, next);

        int maxArea = 0;

        /*
         * Consider every bar as the SMALLEST bar
         * of a potential rectangle.
         */
        for (int i = 0; i < n; i++) {

            // Current bar determines rectangle height.
            int height = arr[i];

            /*
             * Width = Right Boundary - Left Boundary - 1
             *
             * Previous smaller and next smaller bars
             * cannot be included in our rectangle.
             */
            int width = next[i] - prev[i] - 1;

            // Calculate rectangle area.
            int area = height * width;

            // Update maximum area found so far.
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }


    public static void main(String[] args) {

        int[] arr = {60, 20, 50, 40, 10, 50, 60};

        System.out.println("Histogram: " + Arrays.toString(arr));

        System.out.println("Largest Rectangle Area: " + getMaxArea(arr));
    }
}
