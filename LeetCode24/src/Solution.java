public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode front, mid, back, root, rear;
        root = new ListNode(-1);
        root.next = head;
        rear = root;
        front = mid = back = head;
        while (true) {
            if (back == null)
                break;
            mid = back.next;
            if (mid == null)
                break;
            front = mid.next;
            
            rear.next = mid;
            mid.next = back;
            back.next = front;
            
            if (front == null)
                break;
            rear = back;
            back = front;
        }
        return root.next;
    }
}