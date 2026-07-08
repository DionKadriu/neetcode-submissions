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

        if (root == null) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){

            int size = queue.size();
            boolean taken = false;
            for(int i = 0; i < size; i++){
                
                TreeNode node = queue.poll();

                if (!taken){
                    result.add(node.val);
                    taken = true;
                }
                if (node.right != null){
                    queue.add(node.right);
                }
                if (node.left != null){
                    queue.add(node.left);
                }
                
            }
        }

        return result;
    }
}
