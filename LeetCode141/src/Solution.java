public class Solution {
	
	
/* Rabbit-Turtle algorithm 
 * 
 *  bool hasCycle(ListNode *head) {
        if(head == NULL || head -> next == NULL)    
            return false;

        ListNode *fast = head;
        ListNode *slow = head;

        while(fast -> next && fast -> next -> next){
            fast = fast -> next -> next;
            slow = slow -> next;
            if(fast == slow)
                return true;
        }

        return false;
    }*/
	
/*	
 * A recursive algorithm
 * 
 * class HasCycleInLinkedList{
		   public boolean hasCycle(ListNode head){
		       if(head == null || head.next == null) return false;
		       if(head.next == head) return true;
		       ListNode nextNode = head.next; 
		       head.next = head;
		       boolean isCycle = hasCycle(nextNode);
		       return isCycle;
		   }
		}*/
    
    public boolean hasCycle(ListNode head) {
        ListNode nilNode = new ListNode(-1), tmp;
        tmp = head;
        while (tmp != null){
            head = head.next;
            tmp.next = nilNode;
            tmp = head;
            if (tmp == nilNode)
                return true;
        }
        return false;
    }
}