class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res= new ArrayList();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<Integer>(), nums,0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> curr, int nums[], int start){

        res.add(new ArrayList(curr));

        if (curr.size() == nums.length){
            return;
        }

        for (int i = start; i< nums.length; i++){

            if ((i > start && nums[i] == nums[i-1])){
                continue;
            }


            curr.add(nums[i]);
            backtrack(res, curr, nums,i+1);
            curr.remove(curr.size()-1);

        }

    }
}
