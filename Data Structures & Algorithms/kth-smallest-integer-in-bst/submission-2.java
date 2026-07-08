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
        
        int [] decrement = new int[1];
        List<Integer> list = new ArrayList<>();
         dfs(root, decrement,list);
         return list.get(k - 1);
    }

    public void dfs(TreeNode root,int k[], List<Integer> res){

        if (root == null) return;

        dfs(root.left,k,res);
          res.add(root.val);
        dfs(root.right,k,res);
  
  
      
    }
}
