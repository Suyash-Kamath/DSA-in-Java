public class MaximumSubarrayKadanesAlgorithm {

    static int maximumSubarrayBruteForce(int[] arr) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;

            for (int j = i; j < arr.length; j++) {
                currentSum = currentSum + arr[j];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int ans = maximumSubarrayBruteForce(arr);

        System.out.println("Maximum Subarray Sum is: " + ans);
    }
}