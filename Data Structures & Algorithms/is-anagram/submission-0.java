class Solution {
    public boolean isAnagram(String s, String t) {
        int [] sa = new int[26];

        for (char c : s.toCharArray()){
            sa[c - 'a']++;
        }

        for (char c : t.toCharArray()){
            sa[c - 'a']--;
        }

                for (int i = 0; i< 26; i++){
            if (sa[i]!=0){
                return false;
            }
        }
        return true;
    }
}
