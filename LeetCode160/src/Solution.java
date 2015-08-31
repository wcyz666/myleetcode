/*
 * ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) 
{
    ListNode *p1 = headA;
    ListNode *p2 = headB;

    if (p1 == NULL || p2 == NULL) return NULL;

    while (p1 != NULL && p2 != NULL && p1 != p2) {
        p1 = p1->next;
        p2 = p2->next;

        //
        // Any time they collide or reach end together without colliding 
        // then return any one of the pointers.
        //
        if (p1 == p2) return p1;

        //
        // If one of them reaches the end earlier then reuse it 
        // by moving it to the beginning of other list.
        // Once both of them go through reassigning, 
        // they will be equidistant from the collision point.
        //
        if (p1 == NULL) p1 = headB;
        if (p2 == NULL) p2 = headA;
    }

    return p1;
}
 */


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 1;
        int lenB = 1;
        int minLen;
        ListNode hA = headA;
        ListNode hB = headB;
        
        if (headA == null || headB == null)
            return null;
        while (hA.next != null) {
            ++lenA;
            hA = hA.next;
        }
        
        while (hB.next != null) {
            ++lenB;
            hB = hB.next;
        }
        
        if (hA != hB)
            return null;
        
        hA = headA;
        hB = headB;
        minLen = Math.min(lenA, lenB);
        
        if (lenB > lenA)
            for (int i = 0; i < lenB - lenA; i++) {
                hB = hB.next;    
            }
        if (lenA > lenB)
            for (int i = 0; i < lenA - lenB; i++) {
                hA = hA.next;    
            }
            
        for (int i = 0; i < minLen; i++) {
            if (hA == hB) {
                return hA;
            }
            hA = hA.next;
            hB = hB.next;
        }
        
        return null;
        
    }
}