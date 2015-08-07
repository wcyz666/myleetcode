 class ListNode {
      public int val;
      public ListNode next;
      public ListNode(int x) { val = x; }
  }
 
public class Solution {
    
    
    public ListNode ReverseBetween(ListNode head, int m, int n) {

        ListNode aHead = new ListNode(-1);
        ListNode tail = null;
        int count = 0;
        for (;;) {
            count++;
            
            if (count >= m) {
                if (count == m)
                    tail = head;
                ListNode tmp = head;
                head = head.next;
                tmp.next = aHead.next;
                aHead.next = tmp;
                if (count == n) {
                    tail.next = head;
                    break;
                }
            }
            else {
                aHead.next = head;
                head = head.next;
                aHead = aHead.next;
                aHead.next = null;
            }
        }
        
        return aHead.next;
    }
    
}