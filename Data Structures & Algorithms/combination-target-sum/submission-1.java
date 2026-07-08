class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
       List<List<Integer>> res = new ArrayList();
       List<Integer> list = new ArrayList();

       backtrack(res,list,target,target,nums,0);
       return res; 
    }

    public void backtrack(List<List<Integer>>res, List<Integer> path, int dec, int target,int []nums ,int index){
        

        if(dec == 0){
            res.add(new ArrayList(path));
        }

        for (int i = index; i < nums.length;i++){
            
            if (dec + nums[i] < 0) continue;
            path.add(nums[i]);

            backtrack(res,path,dec - nums[i], target,nums,i);

            path.remove(path.size()-1);
        }
    
    }

  
}
