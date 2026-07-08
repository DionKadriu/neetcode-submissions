
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int res [] = new int[1];
        height(root,res);
        return res[0];
    }

    public int height(TreeNode root, int[] res){
        if (root == null) return 0;

        int left = height(root.left, res);
        int right = height(root.right, res);

        res[0] = Math.max(res[0], left + right);

        return 1 + Math.max(left, right);
    }
}
