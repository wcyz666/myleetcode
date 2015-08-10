 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        return _buildTree(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);
    }
    
    public TreeNode _buildTree(int[] preorder, int[] inorder, int left, int right, int pLeft, int pRight) {
        if (left > right)
            return null;
        int i = left;
        int pos = 0;
        TreeNode root = new TreeNode(preorder[pLeft]);
        
        for (; i <= right; i++) {
            if (inorder[i] == root.val)
                break;
        }

        
        root.left = _buildTree(preorder, inorder, left, i - 1, pLeft + 1, pLeft + pos - left);
        root.right = _buildTree(preorder, inorder, i + 1, right, pRight - right + pos + 1, pRight);
        return root;
    }
    
    public static void main(String[] args) {
		new Solution().buildTree(new int[]{1, 2, 3, 4}, new int[]{4, 3, 2, 1});
	}
    
}