
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
public class Solution {
    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode root = head;
        while (head != null && head.next != null) {
            if (head.next.val == val)
                head.next = head.next.next;
            else
                head = head.next;
        }
        return root;
    }
}