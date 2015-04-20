public class Solution {
    
    private static final ListNode nil = new ListNode(-1);
    private static final ListNode nilB = new ListNode(-1);
    
    public ListNode partition(ListNode head, int x) {
    	ListNode curr1 = nil, curr2 = nilB;      
	    while (head!=null){
	        if (head.val<x) {
	            curr1.next = head;
	            curr1 = head;
	        }else {
	            curr2.next = head;
	            curr2 = head;
	        }
	        head = head.next;
	    }
	    curr2.next = null;         
	    curr1.next = nilB.next;
	    return nil.next;

    	
    }
    
}