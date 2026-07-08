class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> res = new ArrayList();
      List<Integer> curr = new ArrayList();
      backtrack(res,curr,nums,0);
      return res;  
    }

    public void backtrack(List<List<Integer>> res, List<Integer>curr, int[]nums, int start){

        res.add(new ArrayList(curr));
        if (curr.size() == nums.length){
            return;
        }

        for (int i = start; i < nums.length; i++){
            if (curr.contains(nums[i])){
                continue;
            }
            curr.add(nums[i]);
            backtrack(res,curr,nums,i);
            curr.remove(curr.size()-1);
        }
    }
}
