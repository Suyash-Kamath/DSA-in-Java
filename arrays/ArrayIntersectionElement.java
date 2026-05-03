import java.util.*;

public class ArrayIntersectionElement {

    public static void intersection(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // store frequency of arr1
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // check elements in arr2
        for (int num : arr2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                System.out.print(num + " ");
                map.put(num, map.get(num) - 1); // decrease freq
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3};
        int[] arr2 = {2, 2, 4};

        intersection(arr1, arr2);
    }
}