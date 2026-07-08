class Solution {

    int[][] DIRECTIONS = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for (int i = 0; i< rows; i++){
            for (int j = 0; j < cols; j++){

                if (grid[i][j] == '1'){
                    dfs(i,j,rows,cols,grid);
                    islands++;
                }
            }
        }
        
        return islands;
    }

    public void dfs(int i, int j, int rows, int cols, char[][]grid){

        if (i >= rows || j >= cols || i <0 || j < 0 || grid[i][j] != '1'){
            return;
        }

        grid[i][j] = 0;
        for (int dir[] : DIRECTIONS){
            dfs(i + dir[0], j+ dir[1], rows,cols,grid);
        }

    }
}
