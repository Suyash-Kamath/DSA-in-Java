public class FindUniqueElement {
    
    public static int findUnique(int[] arr) {
        // T.C is O(N) and S.C is O(1)
        int xor = 0;

        for (int num : arr) {
            xor = xor ^ num;
        }

        return xor;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 4, 5, 3, 4};  // 2 is unique

        int result = findUnique(arr);

        System.out.println("Unique element is: " + result);
    }
}