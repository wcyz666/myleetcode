import java.util.ArrayList;
import java.util.List;

public class Solution {
	
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

    
    public static void main(String[] args) {

	}
}