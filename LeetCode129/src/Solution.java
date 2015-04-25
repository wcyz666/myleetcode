public class Solution {
	
	class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        return _sum(root, 0);
    }
    private int _sum(TreeNode root, int prevSum){
        int thisSum = prevSum * 10 + root.val;
        int leftSum = (root.left == null) ? 0 : _sum(root.left, thisSum);
        int rightSum = (root.right == null) ? 0 : _sum(root.right, thisSum);
        return (leftSum + rightSum == 0) ? thisSum : leftSum + rightSum;
    }
}