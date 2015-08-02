class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((q.val - root.val) * (p.val - root.val) <= 0)
            return root;
        else
            if (q.val > root.val)
                return lowestCommonAncestor(root.right, p, q);
            else
                return lowestCommonAncestor(root.left, p, q);
    }
}

