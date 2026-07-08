class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap();

        for (String str : strs){
            
            char [] unsorted = str.toCharArray();

            Arrays.sort(unsorted);

            String sorted = new String(unsorted);

            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
