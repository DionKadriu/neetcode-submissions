class Solution {
    public int numIslands(char[][] grid) {
        
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == '1'){
                    dfs(grid, i, j, rows, cols);
                    islands++;
                }
            }
        }
        return islands;
    }
    int DIRECTIONS[][] = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public void dfs(char[][]grid, int i, int j, int rows, int cols){

        if (i < 0 || i >= rows || j >= cols || j < 0 || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '0';

        for (int dir[] : DIRECTIONS){
            dfs(grid, i + dir[0], j + dir[1], rows,cols);
        }
    }
}
