/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(
            (a,b) -> Integer.compare(a,b));


        dfs(queue, root);
        k--;

        while (k>0){
            queue.poll();
            k--;
        }
        return queue.poll();
    }
    public void dfs(PriorityQueue queue, TreeNode root){
        if (root == null){
            return;
        }
        queue.add(root.val);
        dfs(queue,root.left);
        dfs(queue,root.right);
    }
}
