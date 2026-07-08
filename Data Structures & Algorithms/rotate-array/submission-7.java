class Solution {
    public void rotate(int[] nums, int k) {
        
        int pos = (k % nums.length);
        rev(nums,0,nums.length - 1);
        rev(nums,0,pos - 1);
        rev(nums, pos , nums.length - 1);
       
    }

    public void rev(int nums[], int i, int j){

        while (i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}