class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean [][] pacific = new boolean[rows][cols];
        boolean [][] atlantic = new boolean[rows][cols];

        for (int i = 0; i < rows; i++){
            dfs(heights,pacific,i,rows, 0,cols,heights[i][0]);
            dfs(heights,atlantic,i,rows, cols-1,cols,heights[i][cols-1]);
        }

        for (int j = 0; j < cols; j ++){
            dfs(heights,pacific,0,rows, j,cols,heights[0][j]);
            dfs(heights,atlantic,rows-1,rows, j,cols,heights[rows-1][j]);
        }
        List<List<Integer>> res = new ArrayList();
        for (int i = 0; i< rows; i++){
            for (int j = 0; j< cols; j++){
                if (pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;

    }
    int [][] DIRECTIONS = new int [][]{{1,0},{0,1},{-1,0},{0,-1}};
    public void dfs(int[][] heights, boolean[][]ocean, int row , int rows, int col, int cols, int val){
       if(row <0 || row >= rows 
       || col < 0 || col >= cols || ocean[row][col] || heights[row][col]< val
       ){
        return;
       }
        ocean[row][col] = true;
       for (int dir[] : DIRECTIONS){
        dfs(heights, ocean, row + dir[0],rows, col + dir[1],cols,heights[row][col]);
       }

    }
}
