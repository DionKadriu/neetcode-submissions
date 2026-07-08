class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), 1, k, n + 1);
        return list;
    }

    public void backtrack(List<List<Integer>> res , List<Integer> path, int idx, int k,int n){

        if (path.size() == k){
            res.add(new ArrayList(path));
        }

        for (int i = idx; i <n; i++){
            
            path.add(i);
            backtrack(res, path, i + 1, k,n);
            path.remove(path.size() - 1);
        }
    }
}