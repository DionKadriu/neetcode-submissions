class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
       List<List<Integer>> res = new ArrayList();
       List<Integer> list = new ArrayList();

       backtrack(res,list,target,target,nums,0);
       return res; 
    }

    public void backtrack(List<List<Integer>>res ,List<Integer> curr,int sum, int target,int nums[],int start){

        if (sum < 0){
            return;
        }
        if (sum == 0){
            res.add(new ArrayList(curr));
        }
        for(int i = start; i< nums.length; i++){
            curr.add(nums[i]);
            backtrack(res,curr,sum - nums[i],target,nums,i);
            curr.remove(curr.size()-1);
        }
    }
}
