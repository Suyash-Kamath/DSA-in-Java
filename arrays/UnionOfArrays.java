import java.util.*;

public class UnionOfArrays {

    public static void union(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();

        // add elements of arr1
        for (int num : arr1) {
            set.add(num);
        }

        // add elements of arr2
        for (int num : arr2) {
            set.add(num);
        }

        // print union
        for (int num : set) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3};
        int[] arr2 = {2, 3, 4};

        union(arr1, arr2);
    }
}