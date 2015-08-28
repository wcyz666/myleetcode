/*
 * class Solution {
	public:
	    ListNode *list;
	    int count(ListNode *node){
	        int size = 0;
	        while (node) {
	            ++size;
	            node = node->next;
	        }
	        return size;
	    }
	
	    TreeNode *generate(int n){
	        if (n == 0)
	            return NULL;
	        TreeNode *node = new TreeNode(0);
	        node->left = generate(n / 2);
	        node->val = list->val;
	        list = list->next;
	        node->right = generate(n - n / 2 - 1);
	        return node;
	    }
	
	    TreeNode *sortedListToBST(ListNode *head) {
	        this->list = head;
	        return generate(count(head));
	    }
	};
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    
    ListNode _root = new ListNode(0);
    
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        ListNode tmp, tmp1;
        tmp = head;
        _root.next = head;
        tmp1 = _root;
        
        while (head != null && head.next != null && head.next.next != null) {
            head = head.next.next;
            tmp1 = tmp1.next;
            tmp = tmp.next;
        }
        
        TreeNode root = new TreeNode(tmp.val);
        if (_root != tmp1) {
            tmp1.next = null;
            root.left = sortedListToBST(_root.next);
        }
        root.right = sortedListToBST(tmp.next);
        return root;
    }
}