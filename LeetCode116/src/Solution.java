import java.util.LinkedList;
import java.util.Queue;


 class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }


public class Solution {
    public void connect(TreeLinkNode root) {
        
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        TreeLinkNode first = null, second = null;
        queue.offer(root);
        while (!queue.isEmpty()){
            queue.offer(null);
            first = queue.poll();
            for (int i = 0, size = queue.size(); i < size; i++) {
                if (first.left != null) queue.offer(first.left);
                if (first.right != null) queue.offer(first.right);
                second = queue.poll();
                first.next = second;
                first = second;
            }
        }
    }
    public static void main(String[] args) {
		new Solution().connect(new TreeLinkNode(0));
	}
}