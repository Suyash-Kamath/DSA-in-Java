public class SubsequencesWithSumK {

    static boolean solve(int[] arr, int k, int sum, int index) {
        // base case
        if (index >= arr.length) {
            // subsequence ready hai
            // sum track kar rahe hain
            // check whether sum == k

            return sum == k;
        }

        int currentValue = arr[index];

        // Exclude current element
        boolean excludeAns = solve(arr, k, sum, index + 1);

        // Include current element
        boolean includeAns = solve(arr, k, sum + currentValue, index + 1);

        return excludeAns || includeAns;
    }

    static boolean checkSubsequenceSum(int[] arr, int k) {
        int index = 0;
        int sum = 0;

        return solve(arr, k, sum, index);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int k = 9;

        boolean ans = checkSubsequenceSum(arr, k);

        System.out.println(ans);
    }
}
