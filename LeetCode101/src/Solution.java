/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isEqualTree(root.left, root.right);
    }
    private boolean isEqualTree(TreeNode p, TreeNode q){
        if (p == null || q == null)
            return (q == null && p == null);
        else
            return p.val == q.val && isEqualTree(p.left, q.right) && isEqualTree(p.right, q.left);
    }
}