class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> curr = new ArrayList();
        Arrays.sort(candidates);
       backtrack(res,curr,candidates,target,0);
       return res; 
    }

    public void backtrack(List<List<Integer>> res,List<Integer> curr, int nums[],int target, int start){

        if (target <0 ){
            return;
        }
        if (target == 0){
            res.add(new ArrayList(curr));
        }

        for (int i = start; i < nums.length; i++){
           if (i > start && nums[i] == nums[i-1]){
            continue;
           }
            curr.add(nums[i]);

            backtrack(res,curr,nums,target - nums[i],i+1);

            curr.remove(curr.size()-1);
        }
    }
}
