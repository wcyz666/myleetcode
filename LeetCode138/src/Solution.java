class RandomListNode {
      public int label;
      public RandomListNode next, random;
      public RandomListNode(int x) { this.label = x; }
  };
 
public class Solution {
    public RandomListNode CopyRandomList(RandomListNode head) {
         RandomListNode root = new RandomListNode(-1), tail;
         RandomListNode root1 = new RandomListNode(-1);
         root.next = head;
         
         while (head != null) {
             RandomListNode cloneNode = new RandomListNode(head.label);
             cloneNode.next = head.next;
             head.next = cloneNode;
             head = cloneNode.next;
         }
         
         head = root.next;
         
         while (head != null) {
             RandomListNode cloneNode = head.next;
             cloneNode.random = head.random;
             if (cloneNode.random != null)
                cloneNode.random = cloneNode.random.next;
             head = cloneNode.next;
         }
         
         head = root.next;
         tail = root1;
         
         while (head != null) {
             tail.next = head.next;
             head.next = head.next.next;
             head = head.next;
             tail = tail.next;
             tail.next = null;
         }
         head = root.next;
         
         return root1.next;
    }
}