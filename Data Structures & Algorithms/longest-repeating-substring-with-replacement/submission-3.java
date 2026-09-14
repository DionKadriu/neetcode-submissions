class Solution {
    public int characterReplacement(String s, int k) {
        
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max=0;
        int window =0;
        for (int right = 0; right < s.length(); right++){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+ 1);
            window = Math.max(window, map.get(s.charAt(right)));

            while ((right - left + 1 - window) > k){
                map.put(s.charAt(left), map.get(s.charAt(left++)) - 1);
            }    
            max = Math.max(max, right - left  + 1);
        }
        return max;
    }
}
