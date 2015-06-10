
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }
 
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 0;
        int nodeCount = 0;
        TreeNode cur = root;
        
        while (root != null) {
            depth++;
            root = root.right;
        }
        nodeCount = (1 << depth) - 1;
        while (depth > 1) {
            TreeNode tmpNode = cur.right;
            for (int i = 2; i < depth; i++) {
                tmpNode = tmpNode.left;
            }
            if (tmpNode.left == null) {
                cur = cur.left;
            }
            else {
                cur = cur.right;
                nodeCount += (1 << depth);
            }
            depth--;
        }
        if (cur.left != null) {
            nodeCount++;
            if (cur.right != null) {
                nodeCount++;
            }
        }
        return nodeCount;
    }
    public static void main(String[] args) {
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode5 = new TreeNode(5);
		TreeNode treeNode6 = new TreeNode(6);
		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		treeNode2.left = treeNode4;
		treeNode2.right = treeNode5;
		treeNode3.left = treeNode6;
		new Solution().countNodes(treeNode1);
	}
}