class Solution {
    public int jump(int[] nums) {
      int jump = 0;
      int len = 0;
      int far = 0;
      if (nums.length ==1 ){
        return 0;
      }

      for (int i = 0; i< nums.length; i++){

        len = Math.max(len, i + nums[i]);

        if (i == far){
            far = len;
            jump++;

            if (far >= nums.length -1){
                return jump;
            }
        }

      }
      return jump;  
    }
}
