


import java.util.Queue;
import java.util.LinkedList;
public class Solution {
	
	class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return 0;
        queue.offer(root);
        int thisLayer = 1, mindepth = 1;
        while (queue.size() != 0)
        {
            int nextLayer = 0;
        	while (thisLayer > 0){
        		TreeNode tmp = queue.poll();
        		if (tmp.left == null && tmp.right == null)
        			return mindepth;
        		if (tmp.left != null){
        		    queue.offer(tmp.left);
        	        ++nextLayer;
        		}
        		if (tmp.right != null){
        		    queue.offer(tmp.right);
        		    ++nextLayer;
        		}
        		--thisLayer;
        	}
        	thisLayer = nextLayer;
        	++mindepth;
        }  
        return mindepth;
    }
}