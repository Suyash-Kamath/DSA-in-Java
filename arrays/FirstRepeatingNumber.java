import java.util.HashMap;

public class FirstRepeatingNumber {

    public static int firstRepeating(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Find first repeating element
        for (int i : nums) {
            if (freq.get(i) > 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 3, 4, 3, 5, 6};

        int result = firstRepeating(arr);

        System.out.println("First Repeating Number: " + result);
    }
}