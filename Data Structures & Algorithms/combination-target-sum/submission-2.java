class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
       List<List<Integer>> res = new ArrayList();
       backtrack(res,new ArrayList<>(),target,nums,0);
       return res; 
    }

    public void backtrack(List<List<Integer>>res, List<Integer> path, int dec, int nums[],int idx){
    
    if (dec == 0){
        res.add(new ArrayList(path));
        return;
    }
    else if (dec < 0){
        return;
    }

    for (int i = idx; i < nums.length; i++){
        path.add(nums[i]);

        backtrack(res,path, dec - nums[i],nums, i);
        path.remove(path.size()-1);
    }
    
    }
  
}
