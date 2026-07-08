class Solution {
    int count = 0;
    int [][] DIRECTIONS = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        for (int i = 0; i< rows; i++){
            for (int j = 0; j< cols; j++){
                if (grid[i][j] == 1){
                    dfs(i,j,rows,cols,grid);
                    res = Math.max(res,count);
                    count = 0;
                }
            }
        }
        return res;
    }

        public void dfs(int i, int j, int rows, int cols, int[][]grid){

        if(i<0 || i>= rows || j<0 || j>=cols || grid[i][j] != 1){
            return ;
        }
        count++;
        grid[i][j] = 0;
        for (int []dir : DIRECTIONS){
            dfs(i + dir[0], j+ dir[1], rows,cols,grid);
        }
    }
}
