class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        char freq[] = new char[26];
        int max = 0;
        int left = 0;
        int maxCount = 0;
        for (int i = 0; i< len; i++){
            freq[s.charAt(i) - 'A']++;
            maxCount = Math.max(maxCount,freq[s.charAt(i) - 'A']);

            while ((i - left + 1) - maxCount  > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            max = Math.max(max,i - left +1) ;
        }

        return max;
    }
}
