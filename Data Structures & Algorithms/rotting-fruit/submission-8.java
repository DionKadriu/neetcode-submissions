class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == 1){
                    fresh++;
                }
                else if (grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int DIRECTIONS[][] = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        int minutes = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            boolean rot = false;
            for (int k = 0; k < size; k++){
                int [] curr = queue.poll();

                for (int dir[] : DIRECTIONS){
                    int row = dir[0] + curr[0];
                    int col = dir[1] + curr[1];
                    if (row >= 0 && row < rows && col >=0 && col < cols && grid[row][col] == 1){
                        fresh--;
                        grid[row][col] = 2;
                        queue.offer(new int []{row,col});
                        rot = true;
                    }
                }
            }
            if (rot) minutes++;
        }
        return fresh == 0 ? minutes:-1;

    }
}
