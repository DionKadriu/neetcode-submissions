class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) return false;

        int arr[] = new int[26];

        for (int i = 0; i < t.length(); i++){

            arr[t.charAt(i) - 'a']++;
            arr[s.charAt(i) - 'a']--;
        }

        return Arrays.equals(new int[26], arr);
    }
}
