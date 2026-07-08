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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        List<Integer> list = new ArrayList();
        if (root == null){
            return new ArrayList();
        }
        queue.offer(root);
   

        while (!queue.isEmpty()){
            int level = queue.size();
            boolean isTaken = false;
            for (int i = 0; i< level; i++){
                TreeNode node = queue.poll();
                if (!isTaken){
                    list.add(node.val);
                    isTaken = true;
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                if (node.left != null){
                    queue.offer(node.left);
                }
            }
        }

        return list;
    }
}
