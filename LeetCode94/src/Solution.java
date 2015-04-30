import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root; 

        while ( p != null || !s.empty())
        {
            while (p != null)
            {
                s.push(p);
                p = p.left;
            }
            if (!s.empty())
            {
                p = s.pop();
                list.add(p.val);
                p = p.right;
            }
        }
        return list;
    }
}
