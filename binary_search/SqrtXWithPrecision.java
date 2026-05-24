// public class SqrtXWithPrecision {

//     static double mySqrt(int x) {

//         int s = 0;
//         int e = x;
//         double ans = 0;

//         while (s <= e) {

//             int mid = s + (e - s) / 2;

//             if (mid == x / mid) {
//                 ans = mid;
//                 break;
//             } 
//             else if (mid > x / mid) {
//                 e = mid - 1;
//             } 
//             else {
//                 ans = mid;
//                 s = mid + 1;
//             }
//         }

//         double factor = 1;
//         int totalPrecision = 3;

//         for (int round = 1; round <= totalPrecision; round++) {

//             factor = factor / 10;

//             while ((ans + factor) * (ans + factor) <= x) {
//                 ans = ans + factor;
//             }

//             System.out.println("This Round's Answer is " + ans);
//         }

//         return ans;
//     }

//     public static void main(String[] args) {

//         int x = 56;

//         double ans = mySqrt(x);

//         System.out.println(ans);
//     }
// }

public class SqrtXWithPrecision {

    static double mySqrt(int x) {

        int s = 1;
        int e = x;
        double ans = -1;

        if (x == 0) {
            return 0;
        }

        while (s <= e) {

            int mid = s + (e - s) / 2;

            if (mid == x / mid) {
                ans = mid;
                break;
            } 
            else if (mid > x / mid) {
                e = mid - 1;
            } 
            else {
                ans = mid;
                s = mid + 1;
            }
        }

        double factor = 1;
        int totalPrecision = 3;

        for (int round = 1; round <= totalPrecision; round++) {

            factor = factor / 10;

            for (int i = 1; i <= 10; i++) {

                double newAns = ans + factor;

                if (newAns * newAns == x) {
                    ans = newAns;
                    break;
                } 
                else if (newAns * newAns < x) {
                    ans = newAns;
                } 
                else {
                    break;
                }
            }

            System.out.println("This Round's Answer is " + ans);
        }

        return ans;
    }

    public static void main(String[] args) {

        int x = 56;

        double ans = mySqrt(x);

        System.out.println(ans);
    }
}