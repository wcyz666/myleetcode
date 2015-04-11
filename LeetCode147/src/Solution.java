public class Solution {
	public static final ListNode root = new ListNode(-1); 
	
    public ListNode insertionSortList(ListNode head) {
        
    	if (head == null) return null;
    	ListNode cur, front, iter, back;
        iter = root.next = head;
        head = head.next;
        iter.next = null;
        while (head != null){
        	cur = head;
        	head = head.next;
        	cur.next = null;
        	front = root.next;
        	back = root;
        	while (front != null && front.val < cur.val){
        		front = front.next;
        		back = back.next; 
        	}
        	back.next = cur;
        	cur.next = front;
        }
        
        return root.next;
    }
    public static void main(String[] args) {
		ListNode listNode = new ListNode(10);
		ListNode listNode2 = new ListNode(9);
		ListNode listNode3 = new ListNode(8);
		ListNode listNode4 = new ListNode(7);
		ListNode listNode5 = new ListNode(6);
		ListNode listNode6 = new ListNode(5);
		ListNode listNode7= new ListNode(4);
		ListNode listNode8 = new ListNode(3);
		ListNode listNode9 = new ListNode(2);
		ListNode listNode10 = new ListNode(1);
		ListNode listNode11 = new ListNode(0);
		ListNode listNode12 = new ListNode(-1);
		listNode.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		listNode5.next = listNode6;
		listNode6.next = listNode7;
		listNode7.next = listNode8;
		listNode8.next = listNode9;
		listNode9.next = listNode10;
		listNode10.next = listNode11;
		listNode11.next = listNode12;
		listNode12.next = null;
		listNode = new Solution().insertionSortList(listNode);
		while (listNode!=null) {
			System.out.println(listNode.val);
			listNode = listNode.next;
			
		}
	}
}