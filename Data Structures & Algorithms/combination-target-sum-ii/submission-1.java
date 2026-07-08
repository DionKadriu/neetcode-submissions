class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();

        Arrays.sort(candidates);
        combinations(res, new ArrayList(), target, 0, candidates,new boolean[candidates.length],0);
    
        return res;
    }

    public void combinations(List<List<Integer>> res, List<Integer> path, int sum , int index,int[] candidates ,boolean[] picks, int prev){

        if (sum == 0){
            res.add(new ArrayList(path));
            return;
        }

        for (int i = index; i<candidates.length; i++){

            if (sum - candidates[i] < 0 || i > index && candidates[i] == candidates[i-1]) continue;

            if (!picks[i]){
                path.add(candidates[i]);

                picks[i] = true;
                combinations(res,path,sum - candidates[i],i+1,candidates,picks,candidates[i]);

                path.remove(path.size()-1);
                
                picks[i] = false;
            
            }
        }

    }

}
