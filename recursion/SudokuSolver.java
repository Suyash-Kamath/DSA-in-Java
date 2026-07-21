
public class SudokuSolver {

    /**
     * Checks whether placing `charValue` at (rowIndex, colIndex) breaks
     * any Sudoku rule — same row, same column, or same 3x3 sub-box.
     * Returns true only if the cell is "safe" i.e. valid placement.
     */
    static boolean isSafeToPlace(char[][] board, char charValue, int rowIndex, int colIndex) {

        // --- Row check ---
        // rowIndex fixed rahega, colIndex 0 se 8 tak ghumaenge
        for (int col = 0; col < 9; col++) {
            if (board[rowIndex][col] == charValue) {
                return false;
            }
        }

        // --- Column check ---
        // colIndex fixed rahega, rowIndex 0 se 8 tak ghumaenge
        for (int row = 0; row < 9; row++) {
            if (board[row][colIndex] == charValue) {
                return false;
            }
        }

        // --- 3x3 sub-box check ---
        // current cell jis 3x3 box mein hai uska top-left corner nikalo
        int startRow = rowIndex - rowIndex % 3;
        int startCol = colIndex - colIndex % 3;

        // ab us poore 3x3 box ko traverse karo
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int actualRow = startRow + i;
                int actualCol = startCol + j;
                if (board[actualRow][actualCol] == charValue) {
                    return false;
                }
            }
        }

        // teeno checks pass ho gaye, matlab safe hai place karna
        return true;
    }

    /**
     * Board mein sabse pehla empty cell ('.') dhoondhta hai.
     * Agar mil gaya, uska row/col emptyCell array mein store karke true return karta hai.
     * Agar poora board bhara hua hai, false return karta hai (base case ke liye signal).
     */
    static boolean findEmptyCell(char[][] board, int[] emptyCell) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    // empty cell ki row ka index store karo
                    emptyCell[0] = i;
                    // empty cell ki col ka index store karo
                    emptyCell[1] = j;
                    return true;
                }
            }
        }
        // kahin bhi empty cell nahi mila
        return false;
    }

    /**
     * Backtracking ka core logic.
     * Har empty cell pe 1-9 try karo, agar safe hai to place karo aur aage recurse karo.
     * Agar aage jaake stuck ho gaye to undo karke (backtrack) next value try karo.
     */
    static boolean solveSudokuHelper(char[][] board) {

        // base case: agar koi empty cell nahi bacha, matlab board solved hai
        int[] emptyCell = new int[2];
        if (!findEmptyCell(board, emptyCell)) {
            return true;
        }

        // empty cell mil gaya, uska row/col nikal lo
        int rowIndex = emptyCell[0];
        int colIndex = emptyCell[1];

        // 1 se 9 tak har digit try karo is cell ke liye
        for (int value = 1; value <= 9; value++) {
            char charValue = (char) (value + '0');

            if (isSafeToPlace(board, charValue, rowIndex, colIndex)) {
                board[rowIndex][colIndex] = charValue;

                // baaki recursion sambhalega
                if (solveSudokuHelper(board)) {
                    return true;
                }

                // agar recursion solve nahi kar paya aur wapas aaya,
                // current value ko undo karke backtrack karo
                board[rowIndex][colIndex] = '.';
            }
        }

        // koi bhi digit 1-9 kaam nahi aaya is cell ke liye => unsolvable from here
        return false;
    }

    /**
     * Public entry point — board ko in-place solve karta hai.
     */
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        SudokuSolver solver = new SudokuSolver();
        solver.solveSudoku(board);

        // solved board print karo
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
