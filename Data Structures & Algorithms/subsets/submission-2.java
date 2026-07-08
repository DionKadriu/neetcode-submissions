class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums,0);
        return list;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> path, int []nums,int idx){

        res.add(new ArrayList<>(path));
        if (path.size() == nums.length){
            return;
        }
        for (int i = idx; i < nums.length;i++){
            path.add(nums[i]);
            backtrack(res,path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
