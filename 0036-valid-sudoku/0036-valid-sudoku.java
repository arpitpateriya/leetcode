import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rowSet = new HashSet[9];
        HashSet<Character>[] colSet = new HashSet[9];
        HashSet<Character>[] boxSet = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            boxSet[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') continue; // Ignore empty cells

                int boxIndex = (i / 3) * 3 + (j / 3); // Compute 3x3 box index

                // Check if num is already in row, column, or box
                if (rowSet[i].contains(num) || colSet[j].contains(num) || boxSet[boxIndex].contains(num)) {
                    return false;
                }

                // Add num to respective sets
                rowSet[i].add(num);
                colSet[j].add(num);
                boxSet[boxIndex].add(num);
            }
        }

        return true; // Valid Sudoku
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

        System.out.println(sol.isValidSudoku(board)); // Output: true
    }
}
