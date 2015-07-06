 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 /*int kthSmallest(TreeNode* root, int& k) {
	    if (root) {
	        int x = kthSmallest(root->left, k);
	        return !k ? x : !--k ? root->val : kthSmallest(root->right, k);
	    }
	}
	*/
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int leftNum = (root == null) ? 0 : findNum(root.left);
        if (k - 1 == leftNum)
            return root.val;
        else if (k - 1 < leftNum)
            return kthSmallest(root.left, k);
        else 
            return kthSmallest(root.right, k - 1 - leftNum);
    }
    private int findNum(TreeNode root) {
        if (root == null)
            return 0;
        else
            return findNum(root.left) + findNum(root.right) + 1;
    }
}