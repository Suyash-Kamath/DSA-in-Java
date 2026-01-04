package arrays;

import java.util.Arrays;

public class LeftRotateAnArrayByOne {

    public static void leftRotate(int[] nums) {
        int temp = nums[0];

        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }

        nums[nums.length - 1] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        leftRotate(nums);

        System.out.println("Rotated Array by 1: " + Arrays.toString(nums));
    }
}
