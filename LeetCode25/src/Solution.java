class ListNode {
      public int val;
      public ListNode next;
      public ListNode(int x) { val = x; }
  }
 
public class Solution {
    public ListNode ReverseKGroup(ListNode head, int k) {

         ListNode root, tmp, tail, tail2;
         root = new ListNode(-1);
         tmp = new ListNode(-1);
         tmp.next = null; 
         root.next = null;
         tail2 = root;
         
         for (;;) {
             if (head == null)
                 break;
             int count = 0; 
             tail = head;
             while (count < k) {
                 if (head != null) {
                     count++;
                     ListNode tmp2 = head.next;
                     head.next = tmp.next;
                     tmp.next = head;
                     head = tmp2;
                 }
                 else {
                     break;
                 }
             }
             
             if (count == k) {
                 tail2.next = tmp.next;
                 tmp.next = null;
                 tail2 = tail;
             }
             else {
                 tmp = tmp.next;
                 while (tmp != null) {
                     ListNode tmp2 = tmp.next;
                     tmp.next = tail2.next;
                     tail2.next = tmp;
                     tmp = tmp2;
                 }
                 break;
             }
             
         }
         
         return root.next;
         
    }
    
}