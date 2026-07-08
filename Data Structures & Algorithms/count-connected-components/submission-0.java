class Solution {
    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList();
int result = 0;
        for (int i = 0; i< n ;i++){
            adj.add(new ArrayList());
        }
        for (int edge [] : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean visited[] = new boolean[n];

        for (int i = 0; i< n; i++){
            if (!visited[i]){
                dfs(adj,visited,i);
                result++;
            }
        }
        return result;
    }
    private void dfs(List<List<Integer>> adj, boolean[] visited, int node){

        visited[node] = true;

        for (int nei: adj.get(node)){
            if (!visited[nei]){
                dfs(adj,visited,nei);
            }
        }
    }
}
