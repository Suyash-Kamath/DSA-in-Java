public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        // T.C is O(N^2) and S.C is O(1)
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j}; // returning indices
                }
            }
        }

        return new int[]{-1, -1}; // if not found
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(arr, target);

        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}