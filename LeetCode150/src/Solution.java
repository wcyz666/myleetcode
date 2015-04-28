import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        
        for (String ope : tokens){
            if (ope.length() > 1){
                stack.push(Integer.parseInt(ope));     
                continue;
            }
            switch (ope.charAt(0)){
                case '+':
                    stack.push(stack.pop() + stack.pop());
                    break;                   
                case '-':
                    int lesser = stack.pop();
                    stack.push(stack.pop() / lesser);
                    break;
                case '*':
                    stack.push(stack.pop() * stack.pop());
                    break; 
                case '/':
                    int divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                    break;
                default:
                    stack.push(Integer.parseInt(ope));
            }
        }
        return stack.peek();
    }
    public static void main(String[] args) {
		new Solution().evalRPN(new String[]{"4","-2","/","2","-3","-","-"});
	}
}