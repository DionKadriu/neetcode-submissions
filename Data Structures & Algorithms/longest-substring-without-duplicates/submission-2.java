class Solution {
    public int lengthOfLongestSubstring(String s) {
       
       int len = 0;
       HashSet<Character> set = new HashSet();
        int count = 0;
        int left = 0;
       for (int right = 0; right < s.length();right++){
        
        if (!set.add(s.charAt(right))){

            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left++));
            }    
        }
        set.add(s.charAt(right));

       
       len = Math.max(len, right - left + 1);
       }
       return len;

    }
}


/***


z   x   y   z






**/






