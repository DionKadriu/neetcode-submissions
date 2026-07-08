class Solution {
    public int maxProduct(int[] nums) {
       if (nums == null || nums.length == 0) return 0;

        int min = 1;
        int max = 1;
        int res = nums[0];

        for (int num : nums){
            int tmp = max * num;
            max = Math.max(num, Math.max(tmp,min * num));
            min = Math.min(num,Math.min(tmp, min * num));

            res = Math.max(max,res);
        }
        return res;
    }
}



///[]
