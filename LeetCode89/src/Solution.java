import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class Solution {

/*	public List<Integer> grayCode(int n) {
	    List<Integer> result = new LinkedList<>();
	    for(int i=0;i<1<<n;i++) result.add(i^i>>1);
	    return result;
	}*/
	
    public List<Integer> grayCode(int n) {
        
        List<Integer> list = new LinkedList<>();
        list.add(0);          
        if (n == 0) 
            return list;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        int pow2 = 1 << n;
        int pow2Round = 1;
        for (int i = 0; i < n; i++) {
            int adder = 1 << i;
            while (!stack.isEmpty()) {
                list.add(stack.pop() + adder);
            }
            for (Integer integer : list) {
                stack.push(integer);
            }
        }
        
        return list;
    }
}
