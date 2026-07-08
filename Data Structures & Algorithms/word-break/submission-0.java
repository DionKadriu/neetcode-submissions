class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean dp[] = new boolean[n+1];
        dp[n] = true;

        for (int i = n - 1; i>=0; i--){

            for(String w : wordDict){
                int endPos = i + w.length();
                if (endPos <= n && s.substring(i, endPos).equals(w)){
                    dp[i] = dp[endPos];
                }

                if (dp[i]){
                    break;
                }

            }

        }
        return dp[0];
    }
}
