 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 /*
  * public ListNode reverseList(ListNode head) {
    ListNode newHead = null;
    while(head != null){
        ListNode next = head.next;
        head.next = newHead;
        newHead = head;
        head = next;
    }
    return newHead;
}
// recursive solution

public ListNode reverseList(ListNode head) {
    return reverseListInt(head, null);
}

public ListNode reverseListInt(ListNode head, ListNode newHead) {
    if(head == null)
        return newHead;
    ListNode next = head.next;
    head.next = newHead;
    return reverseListInt(next, head);
}
  * 
  */
public class Solution {
    
    ListNode root;
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        else {
            _reverseList(head);
            return root;
        }
    }
    public ListNode _reverseList(ListNode head) {
        if (head.next == null) {
            root = head;
            return head;
        }
        else {
            _reverseList(head.next).next = head;
            head.next = null;
            return head;
        }
    }
}