import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null) return lists;
        TreeNode first = null;
        int j = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            if (j % 2 == 0) {
                for (int i = 0, size = queue.size(); i < size; i++) {
                    first = queue.poll();
                    list.add(first.val);
                    if (first.left != null) queue.offer(first.left);
                    if (first.right != null) queue.offer(first.right);
                }                
            }
            else {
                for (int i = 0, size = queue.size(); i < size; i++) {
                    first = queue.removeLast();
                    list.add(first.val);
                    if (first.right != null) queue.offerFirst(first.right);
                    if (first.left != null) queue.offerFirst(first.left);
                }  
            }
            lists.add(list);
            j++;
        }
        
        return lists;
    }

}