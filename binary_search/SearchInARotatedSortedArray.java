public class SearchInARotatedSortedArray {

    static int findPivotIndex(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int ans = -1;

        // Array already sorted
        if (nums[start] <= nums[end]) {
            return -1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] <= nums[n - 1]) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }

        return ans;
    }

    static int binarySearch(int[] nums, int target, int s, int e) {

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] == target) {
                return mid;
            } 
            else if (target > nums[mid]) {
                s = mid + 1;
            } 
            else {
                e = mid - 1;
            }
        }

        return -1;
    }

    static int search(int[] nums, int target) {

        int n = nums.length;

        int pivotIndex = findPivotIndex(nums);

        // Array not rotated
        if (pivotIndex == -1) {
            return binarySearch(nums, target, 0, n - 1);
        }

        // Search in left sorted part
        if (target >= nums[0] && target <= nums[pivotIndex]) {
            return binarySearch(nums, target, 0, pivotIndex);
        }

        // Search in right sorted part
        return binarySearch(nums, target, pivotIndex + 1, n - 1);
    }

    public static void main(String[] args) {

        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        int target = 0;

        int ans = search(nums, target);

        System.out.println("Target found at index: " + ans);
    }
}