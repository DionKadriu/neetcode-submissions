class Solution {

    public void islandsAndTreasure(int[][] grid) {
        
    int DIRECTIONS [][] = new int [][]{{1,0}, {0,1},{-1,0},{0,-1}};

    int rows  = grid.length;
    int cols = grid[0].length;
    Queue<int[]> queue= new LinkedList();

    boolean visited [][]= new boolean[rows][cols];

     for (int i = 0; i < rows; i++){
        for (int j = 0; j < cols; j++){
            if (grid[i][j] == 0){
                queue.offer(new int[]{i,j});
            }
        }
    }   
    int count = 0;
    while (!queue.isEmpty()){

    int[] l = queue.poll();
    int row = l[0];
    int col = l[1];    
    count = 1;
        for (int dir[] : DIRECTIONS){
            count++;
            int nr = dir[0] + row;
            int nc = dir[1] + col;
            if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && grid[nr][nc] == Integer.MAX_VALUE){
                grid[nr][nc] = grid[row][col] +1;
                queue.offer(new int[]{nr,nc});
            }
        }
    
    }   
    
    }
}
