

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

public class Solution {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        while (root.left != null || root.right != null) {
            if (root.left != null) {
                findRightmost(root.left).right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
    public TreeNode findRightmost(TreeNode root) {
        while (root.right != null)
            root = root.right;
        return root;
    }
}