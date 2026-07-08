class Solution {
    public int countSubstrings(String s) {
        int n = s.length(); 
        boolean dp[][] = new boolean[n][n];
        int c = 0;
        for (int i = 0; i < n ; i++){
            dp[i][i] = true;
            c++;
        }

        for (int i = 0; i < n - 1; i++){
            if (s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                c++;
            }
        }

        for (int len = 3; len <= n; len++){
            for (int left = 0; left <= n - len; left++){
                int right = left + len -1; 
            
                if (s.charAt(left) == s.charAt(right) && dp[left+1][right-1]){
                    c++;
                    dp[left][right] = true;
                }
            }
        }
        return c;
    }
}
