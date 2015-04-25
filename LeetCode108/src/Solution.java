public class Solution {
	
	class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
    public TreeNode sortedArrayToBST(int[] num) {
        return _arrayToBST(num, 0, num.length - 1);
    }
    public TreeNode _arrayToBST(int[] num, int left, int right) {
        if (left > right)
            return null;
        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(num[mid]);
        root.left = _arrayToBST(num, left, mid - 1);
        root.right = _arrayToBST(num, mid + 1, right);
        return root;
    }
}