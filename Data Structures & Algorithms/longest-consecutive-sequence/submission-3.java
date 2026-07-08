class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        int res = 0;
        for (int num : nums){
            int curr = num;
            int max =1;
            while (set.contains(--curr)){
                max++;
            }

            res = Math.max(max,res);
        }

        return res;
    }
}
