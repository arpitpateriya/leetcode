class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') { // Find empty cell
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, i, j, num)) { // Check if valid
                            board[i][j] = num; // Place number

                            if (solve(board)) { // Recur to next cell
                                return true;
                            }

                            board[i][j] = '.'; // Backtrack
                        }
                    }
                    return false; // No valid number found, trigger backtracking
                }
            }
        }
        return true; // Board is fully solved
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false; // Check row
            if (board[i][col] == num) return false; // Check column
            int boxRow = 3 * (row / 3) + i / 3, boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == num) return false; // Check 3x3 box
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        sol.solveSudoku(board);
        
        // Print solved board
        for (char[] row : board) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }
}
