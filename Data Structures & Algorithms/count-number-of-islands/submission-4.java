class Solution {
    public int numIslands(char[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols;j++){
                if (grid[i][j] == '1'){
                    dfs(rows,cols,i,j,grid);
                    islands++;
                }
                
            }
        }
        return islands;
    }

    int DIRECTIONS[][] = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public void dfs(int rows, int cols, int i, int j, char[][]grid){

        if (i < 0 || i >= rows || j < 0 || j >=cols || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';

        for (int dir[] : DIRECTIONS){
            dfs(rows,cols,i + dir[0], j + dir[1], grid);
        }
    }
}
