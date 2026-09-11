class Solution {
       public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i) || !isValidCol(board, i)) {
                return false;
            }
        }

        for (int i = 0; i <= 6; i += 3) {
            for (int j = 0; j <= 6; j += 3) {
                if (!checkBox(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkBox(char[][] board, int a, int b) {
        Set<Character> set = new HashSet<>();

        for (int i = a; i < a + 3; i++) {
            for (int j = b; j < b + 3; j++) {
                if (board[i][j] != '.' && !set.add(board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidRow(char[][] board, int i) {
        Set<Character> set = new HashSet<>();

        for (int j = 0; j < 9; j++) {
            if (board[i][j] != '.' && !set.add(board[i][j])) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidCol(char[][] board, int i) {
        Set<Character> set = new HashSet<>();

        for (int j = 0; j < 9; j++) {
            if (board[j][i] != '.' && !set.add(board[j][i])) {
                return false;
            }
        }
        return true;
    }
}
