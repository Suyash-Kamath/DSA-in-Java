import java.util.Arrays;

public class AggressiveCows {

    static boolean isValid(int mid, int[] stalls, int k) {
        int cowCount = 1;

        int lastPosition = 0;

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - stalls[lastPosition] >= mid) {
                cowCount++;
                lastPosition = i;

                if (cowCount == k) {
                    return true;
                }
            }
        }

        return false;
    }

    static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);

        int n = stalls.length;
        int start = 1;
        int end = stalls[n - 1] - stalls[0];
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isValid(mid, stalls, k)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] stalls = {1, 2, 4, 8, 9};
        int k = 3;

        int result = aggressiveCows(stalls, k);

        System.out.println(result);
    }
}