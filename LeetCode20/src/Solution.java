import java.util.Stack;

public class Solution {
	
/*	
 * A clearer solution
 * 
 * 
 * public class Solution {
	    public boolean isValid(String s) {
	        Stack<Character> stack = new Stack<Character>();
	        // Iterate through string until empty
	        for(int i = 0; i<s.length(); i++) {
	            // Push any open parentheses onto stack
	            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
	                stack.push(s.charAt(i));
	            // Check stack for corresponding closing parentheses, false if not valid
	            else if(s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(')
	                stack.pop();
	            else if(s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[')
	                stack.pop();
	            else if(s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{')
	                stack.pop();
	            else
	                return false;
	        }
	        // return true if no open parentheses left in stack
	        return stack.empty();
	    }
	}*/
    public boolean isValid(String s) {
        if (s.length() == 0)
        	return true;
        if (s.length() % 2 == 1)
        	return false;
        Stack<Character> sCharacters = new Stack<>();
        sCharacters.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++){
        	switch (s.charAt(i)) {
			case '(':
			case '{':
			case '[':
				sCharacters.push(s.charAt(i));
				break;
				
			case ')':
			case ']':
			case '}':
				try {
					char c = sCharacters.pop();
					if (s.charAt(i) - c > 2)
						return false;
				} catch (Exception e) {
					// TODO: handle exception
					return false;
				}
				
				break;
				
			default:
				return false;
			}
        }
        return sCharacters.isEmpty();
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().isValid("(({{}}[]))"));
	}
}