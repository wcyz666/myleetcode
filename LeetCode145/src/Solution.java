import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 * 
 *     TreeNode(int x) { val = x; }
 * }
 */
/*class Solution {
public:
    vector<int> postorderTraversal(TreeNode *root) {
        stack<TreeNode*> nodeStack;
        vector<int> result;
        //base case
        if(root==NULL)
        return result;
        nodeStack.push(root);
    while(!nodeStack.empty())
    {
        TreeNode* node= nodeStack.top();  
        result.push_back(node->val);
        nodeStack.pop();
        if(node->left)
        nodeStack.push(node->left);
        if(node->right)
        nodeStack.push(node->right);
    }
     reverse(result.begin(),result.end());
     return result;

}
};*/
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
 
     TreeNode(int x) { val = x; }
 }
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.peek();
            if (tmp.left == null && tmp.right == null){
                list.add(tmp.val);
                stack.pop();
            }
            else {
                if (tmp.right != null)
                    stack.push(tmp.right);
                if (tmp.left != null)
                    stack.push(tmp.left);
                tmp.left = tmp.right = null;
            }
        }
        return list;
    }
}