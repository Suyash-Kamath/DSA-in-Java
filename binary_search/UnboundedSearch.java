class InfiniteArray {

    private int[] arr;

    public InfiniteArray(int[] nums) {
        this.arr = nums;
    }

    public int get(int index) {
        if (index >= arr.length) {
            return Integer.MAX_VALUE;
        }
        return arr[index];
    }
}

class Solution {

    public int unboundedSearch(InfiniteArray arr, int target) {

        if (arr.get(0) == target) {
            return 0;
        }

        int i = 1;

        while (arr.get(i) < target) {
            i = i * 2;
        }

        int s = i / 2;
        int e = i;

        while (s <= e) {

            int mid = s + (e - s) / 2;

            if (arr.get(mid) == target) {
                return mid;
            }

            if (arr.get(mid) > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return -1;
    }
}

public class UnBoundedSearch {

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 7, 9, 11, 13, 15, 17};

        InfiniteArray arr = new InfiniteArray(nums);

        Solution sol = new Solution();

        System.out.println(sol.unboundedSearch(arr, 9));   // 4
        System.out.println(sol.unboundedSearch(arr, 13));  // 6
        System.out.println(sol.unboundedSearch(arr, 8));   // -1
    }
}
