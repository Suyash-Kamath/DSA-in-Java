public class TransposeOfMatrix {

    static int[][] transpose(int[][] arr) {

        if (arr == null || arr.length == 0) {
            return new int[0][0];
        }

        int m = arr.length;
        int n = arr[0].length;

        int newRows = n;
        int newColumns = m;

        int[][] ans = new int[newRows][newColumns];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                ans[col][row] = arr[row][col];
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] ans = transpose(arr);

        // Printing the transpose matrix
        for (int row = 0; row < ans.length; row++) {

            for (int col = 0; col < ans[0].length; col++) {
                System.out.print(ans[row][col] + " ");
            }

            System.out.println();
        }
    }
}