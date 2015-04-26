public class Solution {
    private static final ListNode root = new ListNode(-1);
    
    public ListNode deleteDuplicates(ListNode head) {
        ListNode back = head, front = head, newList = root;
        root.next = null;
        while (back != null) {
            front = front.next;
            while (front != null && front.val == back.val){
                front = front.next;
            }
            if (front == back.next) {
                newList.next = back;
                newList = newList.next;
                newList.next = null;
            }
            back = front;
        }
        return root.next;
    }
}