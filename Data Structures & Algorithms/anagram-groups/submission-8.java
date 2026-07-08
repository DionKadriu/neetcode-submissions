class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList();
        HashMap<String,List<String>> map = new HashMap<>();
        for (String s : strs){
            char arr[] = s.toCharArray();
            Arrays.sort(arr);
            String a = new String(arr);
            
            if (map.containsKey(a)){
                map.get(a).add(s);

            }
            else{
                map.put(a, new ArrayList(Arrays.asList(s)));

            }
        }
        for (Map.Entry<String,List<String>> e : map.entrySet()){
            res.add(e.getValue());
        }
        return res;
    }
}
