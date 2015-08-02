import java.util.Stack;

/*
 * public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    return left == null ? right : right == null ? left : root;
}
 */

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> sp, sq;
        TreeNode target = root, tmp;
        sp = new Stack<>();
        sq = new Stack<>();
        findNode(root, p, sp);        
        findNode(root, q, sq);
        while (!sp.isEmpty() && !sq.isEmpty()) {
            tmp = sp.pop();
            if (tmp == sq.pop())
                target = tmp;
            else
                break;
        }
        return target;
    }
    
    public boolean findNode(TreeNode root, TreeNode p, Stack<TreeNode> s) {
        if (root == null) return false;
        if (root == p) {
            s.push(root);
            return true;
        }
        else if (findNode(root.left, p, s) || findNode(root.right, p, s)) {
            s.push(root);
            return true;
        }
        else 
            return false;
    }
}