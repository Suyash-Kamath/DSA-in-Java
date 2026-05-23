public class SqrtXWithoutPrecision {

    static int mySqrt(int x) {

        int s = 1;
        int e = x;
        int ans = -1;

        if (x == 0) {
            return 0;
        }

        while (s <= e) {

            int mid = s + (e - s) / 2;

            // Perfect square
            if (mid == x / mid) {
                return mid;
            }

            // Mid square is greater than x
            else if (mid > x / mid) {
                e = mid - 1;
            }

            // Mid square is smaller than x
            else {
                ans = mid;
                s = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int x = 56;

        int ans = mySqrt(x);

        System.out.println(ans);
    }
}