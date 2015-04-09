public class Solution {
/* From LeetCode discussion
 * A better solution.  
 *  
	public ListNode rotateRight(ListNode head, int k) {
	    if(head==null||head.next==null||k==0) return head;

	    //make it a cricle, break from k postion far from the head
	    ListNode index=head; int len=1;// int len to record the length of list
	    while(index.next!=null)
	    {index=index.next; len++;}
	    index.next=head;

	    for(int i=0;i<len-k%len;i++)
	    {
	       index=index.next;
	    }
	    ListNode result=index.next;
	    index.next=null;
	    return result;
	}
	*/
	
	public ListNode rotateRight(ListNode head, int k) {
		ListNode rear = null, tmp = head;
        int length = 0;
		while (tmp != null){
			rear = tmp;
			tmp = tmp.next;
			++length;
		}
		if (length <= 1)
			return head;
		int realK = k % length;
		if (realK == 0)
		    return head;
		ListNode root = new ListNode(-1), front, back;
		root.next = head;
		front = back = head;
		for (int i = 0; i < length - realK - 1; i++){
			back = back.next;
			front = front.next;
		}
		front = front.next;

		root.next = front;
		rear.next = head;
		back.next = null;
		
		return root.next;
    }
}