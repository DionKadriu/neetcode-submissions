class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        // Step 1: Build the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);  // Since it's an undirected graph
        }
        Queue<Integer> q = new LinkedList();
        q.offer(0);
        boolean visited[] = new boolean[n];
        visited[0] = true;
        int nodes = 0;

        while (!q.isEmpty()){
            int node = q.poll();
            
            for (int nei : adj.get(node)){
                if (visited[nei]) continue;

                q.offer(nei);
                nodes++;
                visited[nei]= true;
            }
        }
        return nodes == n-1;
    }
}

