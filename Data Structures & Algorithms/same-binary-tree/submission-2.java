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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        List<Integer> left = new ArrayList<>();
         List<Integer> right = new ArrayList<>();
         dfs(p,left);
         dfs(q,right);
         return left.equals(right) && left.size() == right.size();

    }

    public void dfs(TreeNode node,List<Integer> list){

        if (node == null) {list.add(-1); return;}

        list.add(node.val);
        dfs(node.left,list);
        dfs(node.right,list);
    }
}
