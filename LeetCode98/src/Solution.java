import java.util.LinkedList;
import java.util.List;

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
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        preorderTra(list, root);
        if (list.size() <= 1)
            return true;
            
        int prev = list.get(0);
        list.remove(0);
        for (Integer i : list) {
            if (i <= prev)
                return false;
            prev = i;
        }
        return true;
    }
    
    private void preorderTra(List<Integer> list, TreeNode root) {
        if (root == null)
            return;
        preorderTra(list, root.left);
        list.add(root.val);
        preorderTra(list, root.right);
    }
}