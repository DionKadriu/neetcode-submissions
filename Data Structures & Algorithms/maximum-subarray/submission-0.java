class Solution {
    public int maxSubArray(int[] nums) {
        int hold = 0;
        int max = nums[0];

        for (int num : nums){

            hold = Math.max(num, hold + num);

            max = Math.max(max,hold);
        }
        return max;
        
    }
}
