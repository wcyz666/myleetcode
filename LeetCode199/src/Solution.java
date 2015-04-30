import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
  Definition for binary tree
   */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode first = null;
        queue.offer(root);
        while (!queue.isEmpty()){
            for (int i = 0, size = queue.size(); i < size; i++) {
                first = queue.poll();
                if (first.left != null) queue.offer(first.left);
                if (first.right != null) queue.offer(first.right);
            }
            list.add(first.val);
        }
        return list;
    }
}