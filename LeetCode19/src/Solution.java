public class Solution {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode front = head;
        ListNode back = new ListNode(-1);
        ListNode root = back;
        back.next = head;
        
        for (int i = 0; i < n; i++){
            front = front.next;
        }
        
        while (front != null) {
            front = front.next;
            back = back.next;
        }
        
        back.next = back.next.next;

        return root.next;
    }
}