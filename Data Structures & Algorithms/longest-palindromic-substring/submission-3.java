class Solution {
    public String longestPalindrome(String s) {
    
    int len = s.length();
    int max = 1;
     boolean dp[][] = new boolean[len][len];

    int start = 0;
    for (int i = 0; i < len; i++){
        dp[i][i] = true;
    }   


    for (int i = 0; i< len -1 ; i++){
        if (s.charAt(i) == s.charAt(i + 1)){
            dp[i][i+1] = true;
            start = i;
            max = 2;
        }
    }

    for (int l = 3; l <= len; l++){
        for (int i = 0; i <= len - l; i++  ){
            int j = l + i - 1;
            if (j < len){

          
            if (s.charAt(i) == s.charAt(j) && dp[i + 1][j-1]){
                dp[i][j] = true;
                start = i;
                max = l;
            }
            }
        }
    }

    return s.substring(start, start + max);
    }
}

//***
