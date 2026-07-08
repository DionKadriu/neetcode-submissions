class Solution {
    public boolean canJump(int[] nums) {
      int jump = 0;

      for (int i = 0; i< nums.length; i++){

        if (jump >= i){

            jump = Math.max(nums[i]+i,jump);
            if (jump >= nums.length-1){
                return true;
            }
        }
        else{
            return false;
        }

      }

      return false;  
    }
}

/**


jump = 2






*/