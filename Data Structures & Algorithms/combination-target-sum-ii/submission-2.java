class Solution {
   
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       List<List<Integer>> res = new ArrayList<>();
       Arrays.sort(candidates);
       backtrack(res, new ArrayList<Integer>(), target,candidates,0);
       return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> path, int target,int []candidates,int idx){
        if (target == 0){
            res.add(new ArrayList(path));
            return;
        }
        if (target < 0){
            return;
        }

        for (int i = idx; i < candidates.length; i++){
            if (i > idx && candidates[i] == candidates[i-1]) continue;
            path.add(candidates[i]);
            backtrack(res,path,target-candidates[i],candidates,i+1);
            path.remove(path.size()-1);
        }
    }
}

