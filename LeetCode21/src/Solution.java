import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public static int getLeft(int n){
		return 2 * n + 1;
	}
	public static int getRight(int n){
		return 2 * n + 2;
	}
	
	public static <T> void swap (int i, int j, T[] array) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void max_heapfy(int n, WrappedListNode[] array, int length){
		int left = getLeft(n);
		int right = getRight(n);
		int largest = n;
		if (left <= length - 1 && array[left].value < array[n].value){
			largest = left;
		}
		if (right <= length - 1 && array[right].value < array[largest].value){
			largest = right;
		}
		if (largest != n){
			swap(n, largest, array);
			max_heapfy(largest, array, length);
		}
	}
	
	public static void build_heap(WrappedListNode[] array, int length){
		for (int i = length / 2 - 1; i >= 0; i--){
			max_heapfy(i, array, length);
		}
	}
	
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0)
        	return null;
        if (lists.size() == 1)
        	return lists.get(0);
        
        int length = 0;
        WrappedListNode[] array = new WrappedListNode[lists.size()];
        ListNode[] listNodes = new ListNode[lists.size()];
        ListNode head = null, tail, tmp;
        WrappedListNode tmp1, nil = new WrappedListNode(Integer.MAX_VALUE, -1);
        
        for (int i = 0; i < lists.size(); i++){
        	if (lists.get(i) != null){
        		tmp = lists.get(i);
        		WrappedListNode node = new WrappedListNode(tmp.val, i);
        		array[length] = node;
        		length++;
        		lists.set(i, tmp.next);
        		tmp.next = null;
        		listNodes[i] = tmp;
        	}
        }
        if (length == 0)
            return null;

        build_heap(array, length);
        head = tail = new ListNode(listNodes[array[0].listNo].val);
        for (; ;){
        	tmp1 = array[0];
        	if (tmp1.listNo != -1){    	
        		   		
        		tail.next = listNodes[tmp1.listNo];
        		tail = tail.next;
        		tmp = lists.get(tmp1.listNo);
        		if (tmp != null){
        			WrappedListNode node = new WrappedListNode(tmp.val, tmp1.listNo);
        			listNodes[tmp1.listNo] = tmp;
        			array[0] = node;
        			lists.set(tmp1.listNo, tmp.next);
        		}
        		else{
        			array[0] = nil;
        		}
        		max_heapfy(0, array, length);	
        		length--;
        	}
        	else {
				return head.next;
			}
        }        
    }

    
    public static void main(String[] args) {
    	List<ListNode> lists = new ArrayList<>();
    	lists.add(new ListNode(-2));
    	lists.add(new ListNode(1));
    	lists.get(0).next = new ListNode(-1);
    	lists.get(0).next.next = new ListNode(-1);
    	lists.get(0).next.next.next = new ListNode(-1);
    	lists.set(1, null);
    	//lists.add(new ListNode(2));
    	//lists.add(new ListNode(3));
    	//lists.add(new ListNode(6));
    	//lists.get(2).next = new ListNode(4);
		System.out.println(new Solution().mergeKLists(lists));
	}
}