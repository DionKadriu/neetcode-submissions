class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       
       List<List<Integer>> list = new ArrayList();
       int indegree[] = new int[numCourses];

       for (int i = 0; i < numCourses; i++){
            list.add(new ArrayList<Integer>());
       }

       for (int pre[] : prerequisites){
        list.get(pre[1]).add(pre[0]);
        indegree[pre[0]]++;
       }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }
        List<Integer> topSort = new ArrayList();

        while (!queue.isEmpty()){
            int pos = queue.poll();
            topSort.add(pos);
            for (int nei : list.get(pos)){
              indegree[nei]--; 
                if (indegree[nei] == 0){
                    queue.offer(nei);
                } 
            }
        }
        return Arrays.equals(indegree,new int[numCourses]);
       
    }
}








