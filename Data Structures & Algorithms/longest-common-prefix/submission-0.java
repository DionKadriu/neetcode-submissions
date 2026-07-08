class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        int sub = 0;
        int len = Integer.MAX_VALUE;
        
        for (String s : strs){
            len = Math.min(s.length(),len);
        }

        for (int i = 0; i < len; i++){
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++){
                if (strs[j].charAt(i) != c){
                    return strs[0].substring(0,sub);
                }
            }
           sub++;
        }
        return strs[0].substring(0,sub);
        
    }
}