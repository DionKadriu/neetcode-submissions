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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();

        if (root == null){
            return new ArrayList();
        }

        queue.offer(root);

        while (!queue.isEmpty()){
            int level = queue.size();
            ArrayList<Integer> curr = new ArrayList();
            for (int i = 0; i< level; i++){
                TreeNode node = queue.poll();
                curr.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(curr);
        }

        return res;
    }
}
