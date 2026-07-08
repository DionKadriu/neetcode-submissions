class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        int sarr[] = new int[28];
        
        for (int i = 0; i < s.length(); i++){

                sarr[s.charAt(i) - 'a']++;
                sarr[t.charAt(i) - 'a']--;
        }
        return Arrays.equals(sarr, new int[28]);
        
    }
}
