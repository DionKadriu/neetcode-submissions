class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set set = new HashSet<>();
        int right = 0;
        int left = 0;
        int max = 0;
        while (right < s.length()){

            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left++));
            }
            
            max = Math.max(max, right - left + 1);
            set.add(s.charAt(right++));
        }
        return max;
    }
}
