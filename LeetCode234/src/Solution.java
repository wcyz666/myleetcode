class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
public class Solution {
    public ListNode root;
    public boolean isPalindrome(ListNode head) {
        root = head;
        if (head == null)
            return true;
        return _isPalindrome(head);
    }
    
    public boolean _isPalindrome(ListNode head) {
        boolean flag = true;
        if (head.next != null) {
            flag = _isPalindrome(head.next);
        }
        if (flag && root.val == head.val) {
            root = root.next;
            return true;
        }
        return false;
    }
}