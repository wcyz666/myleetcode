public class Solution {
    
    class Result {
        int depth;
        boolean isBalanced;
        
        public Result(int depth, boolean isBalanced) {
            this.depth = depth;
            this.isBalanced = isBalanced;
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        return _isBalanced(root).isBalanced;
    }
    
    public Result _isBalanced(TreeNode root) {
        if (root == null)
            return new Result(0, true);
            
        Result lResult, rResult;
        
        lResult = _isBalanced(root.left);
        rResult = _isBalanced(root.right);
            
        return new Result(Math.max(lResult.depth, rResult.depth) + 1, lResult.isBalanced && rResult.isBalanced && Math.abs(lResult.depth - rResult.depth) <= 1);
    } 
}