class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) return false;

        int arr[] = new int[28];
        for (int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        return Arrays.equals(new int[28], arr);
    }
}
