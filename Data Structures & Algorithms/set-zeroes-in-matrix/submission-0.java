class Solution {
    public void setZeroes(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++ ){
            for (int j = 0; j < cols; j++){
                if (matrix[i][j] == 0){
                    queue.add(new int[]{i,j});
                }
            }
        }

        while (!queue.isEmpty()){

            int loc[] = queue.poll();

            for (int i = 0; i < cols; i++){
                matrix[loc[0]][i] = 0;
            }
            for (int i = 0; i < rows; i++){
                matrix[i][loc[1]] = 0;
            }
        }
        
    }
}
