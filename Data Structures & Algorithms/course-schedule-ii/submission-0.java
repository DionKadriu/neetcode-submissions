class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList();
        Queue<Integer> queue = new LinkedList();
        int []res = new int[numCourses];
        int [] id = new int[numCourses];

        for (int i = 0; i< numCourses; i++){
            list.add(new ArrayList());
        }
        for (int pre[] : prerequisites){
            list.get(pre[1]).add(pre[0]);
            id[pre[0]]++;
        }
        for (int i = 0; i< numCourses; i++){
            if (id[i] == 0){
                queue.offer(i);
            }
        }
        int finish = 0;

        while (!queue.isEmpty()){
            int node = queue.poll();
            res[finish++] = node; 
            for (int nei : list.get(node)){
                id[nei]--;
                if (id[nei] == 0){
                    queue.offer(nei);
                }
            }
        }
        return finish == numCourses ? res : new int[0];
    }
}
