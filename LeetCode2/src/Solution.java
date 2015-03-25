public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int sum, progress = 0;
    	ListNode tmp1 = l1, tmp2 = l2;
        for (;;){
        	sum = l1.val + l2.val + progress;
        	progress = sum >= 10 ? 1 : 0;
        	
        	l1.val = l2.val = sum >= 10 ? sum - 10 : sum;
        	if (l1.next == null){
            	if (l2.next == null){
            		if (progress == 1)
        				l2.next = new ListNode(1);
            		return tmp2;
            	}
            	else {
    				l2 = l2.next;
    			}
            	for (; ;){
            		if (progress == 0)
            			return tmp2;
            		sum = l2.val + 1;
            		progress = sum >= 10 ? 1 : 0;
            		l2.val = sum >= 10 ? 0 : sum;
            		
            		if (l2.next == null){
            			if (progress == 1)
            				l2.next = new ListNode(1);
            			break;
            		}
            		else
            			l2 = l2.next;
            	}
            	return tmp2;
        	}
        	if (l2.next == null){
        		l1 = l1.next;
        		for (; ;){
        			if (progress == 0)
        				return tmp1;
            		sum = l1.val + 1;
            		progress = sum >= 10 ? 1 : 0;
            		l1.val = sum >= 10 ? sum - 10 : sum;

            		if (l1.next == null){
            			if (progress == 1)
            				l1.next = new ListNode(1);
            			break;
            		}
            		else
            			l1 = l1.next;
            	}
            	return tmp1;
        	}
        	l1 = l1.next; 
        	l2 = l2.next;
        		
        }
    }
    
    public static void main(String[] args) {
		ListNode l1, l2, l3;
		l1 = new ListNode(9);
		l2 = new ListNode(8);
		
		l1.next = l2;
		l3 = new ListNode(1);
		new Solution().addTwoNumbers(l1, l3);
	}
}