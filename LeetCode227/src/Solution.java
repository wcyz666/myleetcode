import java.util.LinkedList;
/*
 * public class Solution {
public int calculate(String s) {
    int len;
    if(s==null || (len = s.length())==0) return 0;
    Stack<Integer> stack = new Stack<Integer>();
    int num = 0;
    char sign = '+';
    for(int i=0;i<len;i++){
        if(Character.isDigit(s.charAt(i))){
            num = num*10+s.charAt(i)-'0';
        }
        if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
            if(sign=='-'){
                stack.push(-num);
            }
            if(sign=='+'){
                stack.push(num);
            }
            if(sign=='*'){
                stack.push(stack.pop()*num);
            }
            if(sign=='/'){
                stack.push(stack.pop()/num);
            }
            sign = s.charAt(i);
            num = 0;
        }
    }

    int re = 0;
    for(int i:stack){
        re += i;
    }
    return re;
}
 */

public class Solution {
    public int calculate(String s) {
        int i = 0, length = s.length(), curNum, int1, int2;
        char char1;
        LinkedList<Integer> stackNum = new LinkedList<>();
        LinkedList<Character> stackChar = new LinkedList<>();
        while (i < length) {
            char cur = s.charAt(i);
            switch (cur) {
                case ' ':
                    while (i < length && s.charAt(i) == ' ') i++;
                    break;
                case '+':
                case '-': 
                	if (!stackChar.isEmpty()) {                		
	                    int1 = stackNum.pop().intValue();
	                    int2 = stackNum.pop().intValue();
	                    char1 = stackChar.pop().charValue();
	                    switch (char1) {
	                        case '+':
	                            stackNum.push(int2 + int1);
	                            break;
	                        case '-':
	                            stackNum.push(int2 - int1);
	                            break;
	                        case '*':
	                            stackNum.push(int2 * int1);
	                            break;
	                        case '/':
	                            stackNum.push(int2 / int1); 
	                            break;
	                    }
                	}
                    stackChar.push(cur);
                    ++i;
                    break;
                case '*':
                case '/':
                    if (!stackChar.isEmpty() && (stackChar.peek() == '*' || stackChar.peek() == '/')) {
                        int1 = stackNum.pop().intValue();
                        int2 = stackNum.pop().intValue();
                        char1 = stackChar.pop().charValue();
                        if (char1 == '/')
                            stackNum.push(int2 / int1);
                        else
                            stackNum.push(int2 * int1);
                    }
                    ++i;
                    stackChar.push(cur);
                    break;
                default:
                    curNum = 0;
                    while (i < length && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        curNum = curNum * 10 + s.charAt(i++) - '0';
                    }
                    if (!stackChar.isEmpty() && (stackChar.peek() == '*' || stackChar.peek() == '/')) {
                        int1 = stackNum.pop().intValue();
                        char1 = stackChar.pop().charValue();
                        if (char1 == '/')
                            stackNum.push(int1 / curNum);
                        else
                            stackNum.push(curNum * int1);
                    }
                    else
                    	stackNum.push(curNum);
            }
        }
        while (!stackChar.isEmpty()) {
            int1 = stackNum.poll().intValue();
            int2 = stackNum.poll().intValue();
            char1 = stackChar.poll().charValue();
            switch (char1) {
	            case '+':
	                stackNum.offerFirst(int2 + int1);
	                break;
	            case '-':
	                stackNum.offerFirst(int2 - int1);
	                break;
	            case '*':
	                stackNum.offerFirst(int2 * int1);
	                break;
	            case '/':
	                stackNum.offerFirst(int2 / int1); 
	                break;
            }
        }
        return stackNum.peek();
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().calculate("1*2-3/4+5*6-7*8+9/10"));
	}
}