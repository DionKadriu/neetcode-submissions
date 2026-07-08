class Solution {
    public int subarraySum(int[] nums, int k) {
        

        int res = 0, curSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums){

            curSum += num;
            res += map.getOrDefault(curSum - k, 0);

            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }
        return res;
    }
}
