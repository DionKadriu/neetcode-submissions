class Solution {
    int count = 0;
    int [][] DIRECTIONS = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
      int max = 0;
      int rows = grid.length;
      int cols = grid[0].length;
      for (int i = 0; i < rows; i++ ){
        for (int j = 0; j < cols; j++){
            if (grid[i][j] == 1){
               max =  Math.max(dfs(i,j, rows, cols, grid),max);
            }
        }
      }
      return max;
    }

        public int dfs(int i, int j, int rows, int cols, int[][]grid){

        if(i<0 || i>= rows || j<0 || j>=cols || grid[i][j] != 1){
            return 0;
        }
        grid[i][j] = 0;
        int count = 1;

        for (int dir[] : DIRECTIONS){
            count += dfs(i + dir[0], j + dir[1], rows,cols,grid);
        }

        return count;
      
    }
}
