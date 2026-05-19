public class FindFirstAndLastIndexInASortedArray {

    static int[] searchRange(int[] nums, int target) {

        int[] result = new int[2];

        result[0] = search(nums, target, true);   // first occurrence
        result[1] = search(nums, target, false);  // last occurrence

        return result;
    }

    static int search(int[] nums, int target, boolean findFirst) {

        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {

                ans = mid;

                // search on left side
                if (findFirst) {
                    end = mid - 1;
                }
                // search on right side
                else {
                    start = mid + 1;
                }

            } else if (nums[mid] < target) {

                start = mid + 1;

            } else {

                end = mid - 1;
            }
        }

        return ans;
    }

    static void printArray(int[] arr) {

        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] result = searchRange(nums, target);

        printArray(result);
    }
}