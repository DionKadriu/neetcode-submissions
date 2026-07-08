class Solution {
    public boolean isValidSudoku(char[][] board) {
        
       
        for (int i = 0; i<9; i++){

            if (!checkRow(board,i) || !checkCol(board,i)){
                return false;
            }
        }
        for (int i =0; i<=6 ;i+=3){
            for (int j =0; j<=6; j+=3){
                if (!checkBox(board,i,j)){
                    return false;
                }
            }
        }

        return true; 
    }
    
    
    public boolean checkRow(char[][]board, int i){
        HashSet<Character> set = new HashSet();
        for (int j =0; j< 9;j++){
            
            if (board[i][j]!='.' &&!set.add(board[i][j])){
                return false;
            }
        }
        return true;
    }

    public boolean checkCol(char[][]board, int j){
        HashSet<Character> set = new HashSet();
        for (int i =0; i< 9;i++){
            
            if (board[i][j]!='.' &&!set.add(board[i][j])){
                return false;
            }
        }
        return true;
    }

    public boolean checkBox(char[][]board, int a, int b){
        HashSet<Character> set = new HashSet();
        for (int i =a; i< a+3;i++){
            for (int j =b; j< b+3;j++){
                if (board[i][j]!='.' &&!set.add(board[i][j])){
                return false;
            }
        }
        }
        return true;
    }

}
