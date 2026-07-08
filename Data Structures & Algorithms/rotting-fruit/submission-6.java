class Solution {
    public int orangesRotting(int[][] grid) {
        
        int [][] DIRECTIONS = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]> queue = new LinkedList();

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
            }
        }

        int rotten = 0;

        while (!queue.isEmpty()){
            
            boolean rot = false;
            int size = queue.size();
            for (int i = 0; i < size; i++){

            int [] pos = queue.poll();
            int row = pos[0];
            int col = pos[1];
                for (int dir[] : DIRECTIONS){
                    int r = row + dir[0];
                    int c = col + dir[1];

                    if (r >= 0 && c >= 0 && r < rows && c < cols && grid[r][c] == 1){
                        grid[r][c] = 2;
                        queue.offer(new int[]{r,c});
                        rot = true;
                    }
                }
            }
            if (rot){
                rotten++;
            }
        }
        for (int i = 0; i< rows; i++){
            for (int j = 0; j< cols; j++){
                if (grid[i][j]==1){
                    return -1;
                }
            }
        }


        return rotten;
    }
}
