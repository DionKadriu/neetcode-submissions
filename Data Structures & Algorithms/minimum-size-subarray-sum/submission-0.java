class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int l = 0;

        int max = nums.length + 1;
        int sum = 0;

        for (int r = 0; r < nums.length; r++){
                sum += nums[r];
                while (sum >= target){
                    max = Math.min(max, r - l + 1);
                    sum -= nums[l++];    
                }
        }

        return max == nums.length + 1? 0 : max;
    }
}





