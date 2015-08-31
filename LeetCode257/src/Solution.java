import java.util.LinkedList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        _binaryTreePaths(root, paths, "");
        return paths;        
    }
    
    public void _binaryTreePaths(TreeNode root, List<String> paths, String path) {
        if (root == null)
            return;
        String thisPath = path.length() == 0 ? "" + root.val : path + "->" + root.val;
        if (root.left == null && root.right == null)
             paths.add(thisPath);
        if (root.left != null)
            _binaryTreePaths(root.left, paths, thisPath);           
        if (root.right != null)
            _binaryTreePaths(root.right, paths, thisPath);    
    }
}