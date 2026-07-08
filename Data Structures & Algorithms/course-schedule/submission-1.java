class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList();
        
        for (int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        int [] indegree = new int[numCourses];
        for (int [] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i< numCourses; i++){
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

        return topSort.size() == numCourses;
    }
}
