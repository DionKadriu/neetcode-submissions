class Solution {
    int [][] DIRECTIONS = new int [][]{{0,1},{1,0},{-1,0},{0,-1}};
    public int orangesRotting(int[][] grid) {

       int minutes = 0;
       int rows = grid.length;
       int cols = grid[0].length;

        Queue <int[]> queue = new LinkedList();
        for (int i = 0; i< rows; i++){
            for(int j = 0; j<cols; j++){
                if (grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
            }
        }

        while (!queue.isEmpty()){
            int size = queue.size();

            boolean rot = false;
            for (int i =0; i< size; i++){
               int [] loc = queue.poll();

               for (int dir[]: DIRECTIONS){
                int r = loc[0] + dir[0];
                int c = loc[1] + dir[1];
                    if (r>=0 && r< rows && c>=0 && c<cols && grid[r][c]==1){
                        grid[r][c] = 2;
                        queue.offer(new int[]{r,c});
                        rot = true;
                    }
               } 
            }
            if (rot){
            minutes++;

            }
        }

        for (int i = 0; i< rows; i++){
            for (int j = 0; j< cols; j++){
                if (grid[i][j]==1){
                    return -1;
                }
            }
        }
        return  minutes;
    }
}

/**

grid=[[2,1,1],[0,1,1],[1,0,1]]

2   2   2
0   2   2
1   0   2




*/
