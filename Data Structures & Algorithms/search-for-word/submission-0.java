class Solution {

    public int [][]DIRECTIONS = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i< row; i++){

            for (int j = 0; j< col; j++){
                if (word.charAt(0) == board[i][j]){
                    if (dfs(board,word,row,col,i,j, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][]board, String word, int rows, int cols, int row, int col, int i){

        if (word.length() == i){
            return true;
        }

        if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != word.charAt(i)){
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '£';

        for (int []dir : DIRECTIONS){
            if (dfs(board,word,rows,cols,row + dir[0],col + dir[1], i+1)){
                return true;
            }
        }
        board[row][col] = temp;

        return false;
    }
}
