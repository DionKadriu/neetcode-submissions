class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map = new HashMap<>();

        for (String str : strs){

            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String res = new String(arr);

           if (!map.containsKey(res)) {

                map.put(res, new ArrayList<>());
            }          
            map.get(res).add(str);

        }

             return new ArrayList<>(map.values());
    }
}
