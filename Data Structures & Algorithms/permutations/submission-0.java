class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> curr = new ArrayList();

        permutations(res,curr,nums);
        return res;
    }

    public void permutations(List<List<Integer>>res, List<Integer>curr, int[]nums){

        if (curr.size() == nums.length){
            res.add(new ArrayList(curr));
        }

        for (int num : nums){

            if (curr.contains(num)){
                continue;
            }
            System.out.print(num);
            curr.add(num);
            permutations(res,curr,nums);
            curr.remove(curr.size()-1);
        }
       
    }
}
