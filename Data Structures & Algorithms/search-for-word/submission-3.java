class Solution {
    public boolean exist(char[][] board, String word) {
        
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){

                if (board[i][j] == word.charAt(0)){
                    
                    if (dfs(i,j,rows,cols,board,word,0)){
                        return true;
                    }
                }
            
            }
        }
        return false;
    }
    int[][] DIRECTIONS = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

    public boolean dfs(int i, int j, int rows, int cols, char[][] board, String word, int idx){

        if(i < 0 || j < 0 || i >= rows || j >= cols || board[i][j] != word.charAt(idx)){
            return false;
        }
        if (idx == word.length() - 1){
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '*';

        for (int dir [] : DIRECTIONS){
            if (dfs(i + dir[0], j+ dir[1], rows,cols,board,word,idx+1)){
                return true;
            }
        }

        board[i][j] = temp;

        return false;

    }
}
