import java.util.*;

public class NQueens {

    static boolean isSafeToPlace(int rowIndex, int colIndex, int n, char[][] board) {

        // -----------------------------
        // Check the left horizontal side
        // Since we place queens column by column from left to right,
        // we only need to check the left side of the current row.
        // -----------------------------

        int row = rowIndex;
        int col = colIndex;

        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }

            // Row remains the same.
            // Move towards the left until column becomes 0.
            col--;
        }

        // -----------------------------------------
        // Check the left upper diagonal (↖)
        // Traverse diagonally towards the top-left.
        // -----------------------------------------

        row = rowIndex - 1;
        col = colIndex - 1;

        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }

            row--;
            col--;
        }

        // -----------------------------------------
        // Check the left lower diagonal (↙)
        // Traverse diagonally towards the bottom-left.
        // -----------------------------------------

        row = rowIndex + 1;
        col = colIndex - 1;

        while (row < n && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }

            row++;
            col--;
        }

        // No queen found in any attacking direction.
        return true;
    }

    static void solve(char[][] board, int n, int colIndex, List<List<String>> ans) {

        // -----------------------------
        // Base Case
        // If we have successfully placed queens in all columns,
        // then the current board represents one valid arrangement.
        // Store it inside the answer list.
        // -----------------------------

        if (colIndex >= n) {

            // Board pe ek valid arrangement mil gaya.
            // Is valid configuration ko answer list me store kar do.

            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }

        // ----------------------------------------------------
        // Recursive Thinking
        //
        // Main current column ke har row me jaunga.
        // Agar queen safely place ho sakti hai,
        // to queen place karunga aur remaining columns
        // recursion ko solve karne dunga.
        // ----------------------------------------------------

        for (int rowIndex = 0; rowIndex < n; rowIndex++) {

            if (isSafeToPlace(rowIndex, colIndex, n, board)) {

                // Step 1: Place the queen.
                board[rowIndex][colIndex] = 'Q';

                // Step 2: Solve the remaining columns recursively.
                solve(board, n, colIndex + 1, ans);

                // ------------------------------------------------
                // Step 3: Undo the decision (Backtracking).
                //
                // Jab recursion se wapas aayenge,
                // to current queen hata denge taki
                // isi column ke next row me queen place karke
                // naye possibilities explore kar sake.
                // ------------------------------------------------

                board[rowIndex][colIndex] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        // Create an empty chessboard.
        char[][] board = new char[n][n];

        // Fill every cell with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        int colIndex = 0;

        // Stores all possible valid arrangements.
        List<List<String>> ans = new ArrayList<>();

        solve(board, n, colIndex, ans);

        return ans;
    }

    // ============================================
    // Driver Code (psvm)
    // ============================================

    public static void main(String[] args) {

        NQueens obj = new NQueens();

        int n = 4;

        List<List<String>> ans = obj.solveNQueens(n);

        int solutionNumber = 1;

        for (List<String> solution : ans) {

            System.out.println("Solution " + solutionNumber++);

            for (String row : solution) {
                System.out.println(row);
            }

            System.out.println();
        }
    }
}
