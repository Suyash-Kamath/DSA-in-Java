
import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpanProblem {

    /*
     * APPROACH: MONOTONIC STACK — O(N) TOTAL TIME
     *
     * We are NOT checking every previous day's price one by one.
     * That would take O(N^2) time for N days.
     *
     * Instead, we maintain a stack that helps us skip multiple
     * previous days in a single step.
     *
     * Each stack element stores:
     * [0] -> price
     * [1] -> span of that price
     *
     * When a new price arrives, we pop all previous prices
     * that are LESS THAN OR EQUAL TO the current price.
     *
     * Why?
     * Because the current price is greater than or equal to
     * those previous prices, so those days can be included
     * in the current stock's span.
     *
     * We don't need to examine those days individually.
     * Their spans have already been calculated and stored!
     *
     * We add those spans together to calculate the new span.
     *
     * IMPORTANT:
     * Although one call can pop multiple elements, each element
     * is pushed onto the stack once and popped at most once.
     *
     * Therefore, across N calls:
     * Total pushes <= N
     * Total pops   <= N
     *
     * Total time = O(N), amortized O(1) per next() call.
     * Auxiliary space = O(N) in the worst case.
     */

    static class StockSpanner {

        private Deque<int[]> st;

        // Each element is an int array: [price, span]

        public StockSpanner() {
            st = new ArrayDeque<>();
        }

        public int next(int price) {

            // The current day itself always contributes 1.
            int span = 1;

            // Remove previous prices that are <= current price.
            while (!st.isEmpty() && st.peek()[0] <= price) {

                // Include all the days covered by that price's span.
                span += st.peek()[1];

                // That previous price is no longer needed separately.
                st.pop();
            }

            // Store the current price along with its calculated span.
            st.push(new int[]{price, span});

            return span;
        }
    }

    public static void main(String[] args) {

        StockSpanner stockSpanner = new StockSpanner();

        System.out.println(stockSpanner.next(100)); // 1
        System.out.println(stockSpanner.next(80));  // 1
        System.out.println(stockSpanner.next(60));  // 1
        System.out.println(stockSpanner.next(70));  // 2
        System.out.println(stockSpanner.next(60));  // 1
        System.out.println(stockSpanner.next(75));  // 4
        System.out.println(stockSpanner.next(85));  // 6
    }
}
