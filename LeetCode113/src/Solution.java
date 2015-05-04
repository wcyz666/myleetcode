import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.*/
class TreeNode {
      int val;
    TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    
    private static List<List<Integer>> lists;
    private static final int[] nodeList = new int[1001];
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        lists = new ArrayList<>();
        if (root == null)
            return lists;
        _pathSum(root, sum, 0);
        return lists;
    }
    
    private void _pathSum(TreeNode root, int sum, int depth) {
        nodeList[depth] = root.val;
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i <= depth; i++)
                    list.add(nodeList[i]);
                lists.add(list);
            }
            else
                return;
        }

        if (root.left != null){
            _pathSum(root.left, sum - root.val, depth + 1);
        }
        if (root.right != null){
            _pathSum(root.right, sum - root.val, depth + 1);
        }
    }
}