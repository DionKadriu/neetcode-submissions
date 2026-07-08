class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> adj = new ArrayList();
        int indegree[] = new int[n];
        for (int i = 0; i < n; i++){
            adj.add(new ArrayList());
        }

        for (int pre[] : prerequisites){
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList();

        for (int i = 0; i < n; i++){
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }
        List<Integer> topSort = new ArrayList();
        while (!queue.isEmpty()){

            int node = queue.poll();
            topSort.add(node);

            for (int nei : adj.get(node)){
                indegree[nei]--;
                
                if (indegree[nei] == 0){
                    queue.offer(nei);
                }
            }
        }

        if (topSort.size() != n){
            return new int[]{};
        }

        int res[] = new int[n];
        for (int i = 0; i < n; i++){
            res[i] = topSort.get(i);
        }
       return res;
    }
}
