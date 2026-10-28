/*
import java.util.Arrays;

public class DailyTemperaturesMonotonicStackPattern {

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            // For index i, we want to find the number of days
            // until we encounter a warmer temperature.

            // Start searching from the next day, i + 1.
            for (int j = i + 1; j < n; j++) {

                if (temperatures[j] > temperatures[i]) {
                    // Warmer day mil gaya hai!

                    // Calculate the number of days between
                    // the current day i and the warmer day j.
                    int days = j - i;

                    // Store the answer for day i.
                    ans[i] = days;

                    // We found the FIRST warmer day, so stop searching.
                    break;
                }
            }

            // If no warmer day is found, ans[i] remains 0.
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        int[] result = dailyTemperatures(temperatures);

        System.out.println("Temperatures: " + Arrays.toString(temperatures));
        System.out.println("Answer:       " + Arrays.toString(result));
    }
}

*/

// Stack Approach 



import java.util.*;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];

        // Stack stores the indices of days whose warmer day
        // has not been found yet.
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // For the current day i, check whether its temperature
            // is warmer than the temperature of the day on top
            // of the stack.
            while (!st.isEmpty()
                    && temperatures[i] > temperatures[st.peek()]) {

                // Current day i is the next warmer day for
                // the day whose index is at the top of the stack.
                int previousDay = st.pop();

                // Calculate how many days we waited for a warmer day.
                ans[previousDay] = i - previousDay;
            }

            // Push the current day's index because we haven't
            // found its next warmer day yet.
            st.push(i);
        }

        // Any indices remaining in the stack have no warmer day.
        // Their answers are already 0 in the array.
        return ans;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        int[] result = dailyTemperatures(temperatures);

        System.out.println(Arrays.toString(result));
    }
}
