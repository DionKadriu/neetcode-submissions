class Solution {
    public int[] productExceptSelf(int[] nums) {

        if (nums.length == 1 || nums.length == 0){
            return nums;
        }

       int prefix[] = new int[nums.length];
       Arrays.fill(prefix,1);

        for (int i = 1; i < nums.length; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0 ; i--){
    
            prefix[i] = suffix * prefix[i];
            suffix *= nums[i];
            
        }

        return prefix;
    }
}  








