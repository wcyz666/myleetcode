import java.util.Stack;


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class Solution {
    
    Stack<ListNode> nodes;
    
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next == null) return;
        
        nodes = new Stack<>();
        int i = 0, count = 0;
        ListNode root = head, tmp = null, last = null;
        
        while (head != null) {
            ++count;
            nodes.push(head);
            head = head.next;
        }
        head = root;
        for (; i < count / 2; i++) {
            last = nodes.pop();
            last.next = null;
            tmp = head.next;
            head.next = last;
            last.next = tmp;
            head = tmp;
        }
        head.next = null;
        head = root;
        for (; head != null; head = head.next)
        	System.out.println(head.val);
    }
}