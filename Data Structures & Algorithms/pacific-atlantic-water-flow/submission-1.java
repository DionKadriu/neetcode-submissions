class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> res = new ArrayList();
        int rows = heights.length;
        int cols = heights[0].length;

        boolean atlantic [][] = new boolean[rows][cols];
        boolean pacific [][] = new boolean[rows][cols];

        for (int i = 0; i < cols; i++){
            dfs(0,i,rows,cols,pacific,heights,Integer.MIN_VALUE);
            dfs(rows - 1, i, rows, cols, atlantic, heights, Integer.MIN_VALUE);
        }

        for (int i = 0; i < rows; i++){
            dfs(i, 0, rows, cols, pacific, heights, Integer.MIN_VALUE);
            dfs(i, cols-1, rows, cols, atlantic, heights, Integer.MIN_VALUE);
        }

        for (int i = 0; i < rows; i++){
            
            for (int j = 0; j < cols; j++){
                if (pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
            
        }
        return res;
    }

    int [][] DIRECTIONS = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public void dfs(int row , int col, int rows, int cols, boolean[][] ocean, int grid[][], int prev){

        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] < prev || ocean[row][col]){
            return;
        }

        ocean[row][col] = true;

        for (int dir[] : DIRECTIONS){
            dfs(row + dir[0], col + dir[1], rows, cols, ocean, grid, grid[row][col]);
        }
        
    }
}
