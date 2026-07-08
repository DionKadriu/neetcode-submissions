class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String>> map = new HashMap<>();
        for (String s : strs){
            char arr[] = s.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            map.computeIfAbsent(sorted,k-> new ArrayList()).add(s);
        }

        return new ArrayList(map.values());
    }
}
