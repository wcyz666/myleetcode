import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public ListNode sort(ListNode head) {
		if (head == null || head.next == null)
			return head;
		else {
			ListNode tmp, tmp1 = head;
			tmp = tmp1;
			while (head != null && head.next != null &&  head.next.next != null) {
				tmp = tmp.next;
				head = head.next.next;
			}
			head = tmp.next;
			tmp.next = null;
			ListNode upper = sort(tmp1);
			ListNode lower = sort(head);
			return mergeTwoLists(upper, lower);
		}
	}
	
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0);
        ListNode root = list;
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                list.next = l2;
                l2 = l2.next;
            }
            else{
                list.next = l1;
                l1 = l1.next;
            }
            list = list.next;
        }
        if (l1 == null){
            list.next = l2;
        }
        else{
            list.next = l1;
        }
        return root.next;
    }
	
}