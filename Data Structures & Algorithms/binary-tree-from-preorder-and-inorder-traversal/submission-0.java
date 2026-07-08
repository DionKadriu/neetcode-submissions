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
    int p = 0;
    HashMap<Integer,Integer> map = new HashMap();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if (preorder.length == 0){
            return null;
        }
        if (preorder.length ==1){
            return new TreeNode(preorder[0]);
        }

        for (int i = 0; i< inorder.length; i++){
            map.put(inorder[i],i);
        }

        return helper(0,inorder.length-1,preorder);
    }

    public TreeNode helper(int start, int end, int[] preorder){

        if (start > end){
            return null;
        }
        
        int rootval = preorder[p++];
        TreeNode root = new TreeNode(rootval);
        int endIndex = map.get(rootval);

        root.left = helper(start,endIndex-1,preorder);
        root.right = helper(endIndex+1,end,preorder);
        return root;
    }
}
