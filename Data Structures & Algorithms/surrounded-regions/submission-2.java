class Solution {
    
    public void solve(char[][] board) {
        
        Queue<int[]> queue = new LinkedList();
        int rows = board.length;
        int cols = board[0].length; 

        for (int i = 0; i < rows; i++){
            if (board[i][0] == 'O'){
                board[i][0] = 'l';
                queue.offer(new int[]{i,0});
            }
            if (board[i][cols-1] == 'O'){
                board[i][cols-1] = 'l';
                queue.offer(new int[]{i,cols-1});
            }
        }
        for (int i = 0; i < cols; i++){
        if (board[0][i] == 'O'){
            board[0][i] = 'l';
            queue.offer(new int[]{0,i});
        }
        if (board[rows-1][i] == 'O'){   // Fixed line
            board[rows-1][i] = 'l';
            queue.offer(new int[]{rows-1,i});
        }
    }
        int DIRECTIONS[][] = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

        while (!queue.isEmpty()) {
            int loc[] = queue.poll();
    
            for (int dir[] : DIRECTIONS) {
                int r = dir[0] + loc[0];
                int c = dir[1] + loc[1];
                if (r >= 0 && r < rows && c >= 0 && c < cols && board[r][c] == 'O') {
                    board[r][c] = 'l';
                    queue.offer(new int[] { r, c });
                }
            }
        }

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (board[i][j] == 'l'){
                    board[i][j] = 'O';
                }
                else if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
