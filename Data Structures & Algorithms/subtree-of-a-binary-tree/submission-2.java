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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if (root == null) return false;

        return child(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    public boolean child (TreeNode root, TreeNode subRoot){

        if (root != null && subRoot != null && root.val == subRoot.val) {

            return child(root.left, subRoot.left) && child(root.right,subRoot.right);
        }
        return root == null && subRoot == null;
    }
}
