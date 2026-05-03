public class MissingNumber {

    public static int missingNumber(int[] nums) {
        // T.C is O(N) and S.C is O(1)
        int xorSum = 0;

        // XOR all array elements
        for (int num : nums) {
            xorSum = xorSum ^ num;
        }

        // XOR numbers from 0 to n
        for (int i = 0; i <= nums.length; i++) {
            xorSum = xorSum ^ i;
        }

        return xorSum;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 1};  // Example input

        int result = missingNumber(arr);

        System.out.println("Missing number is: " + result);
    }
}