class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        Map<Integer,Integer> f = new HashMap<>();
        Set<Integer> list = new HashSet<>();
        
        for (int num : nums){
            f.put(num, f.getOrDefault(num,0)+1);
            if (f.get(num) > (nums.length / 3)){
                list.add(num);
            }
        }

        return new ArrayList(list);
    }
}