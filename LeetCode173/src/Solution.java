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

    List<Integer> list;
    Stack<TreeNode> s;
    TreeNode p; 
    
    public Solution(TreeNode root) {
        list = new LinkedList<>();
        s = new Stack<>();
        p = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (p != null || !s.empty())
            return true;
        else
            return false;
    }

    /** @return the next smallest number */
    public int next() {
        int nextVal = 0;
        while (p != null) {
            s.push(p);
            p = p.left;
        }
        p = s.pop();
        nextVal = p.val;
        p = p.right;
        return nextVal;
    }
    
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */