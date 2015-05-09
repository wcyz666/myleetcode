import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
    	StringBuilder stringBuilder = new StringBuilder();
        String[] strings = path.split("/");
        
        Stack<String> stack = new Stack<>();
        for (String string: strings) {
        	switch (string) {
			case ".":
			case "" :
				break;
			
			case "..": 
				if (!stack.isEmpty())
					stack.pop();
				break;
			default:
				stack.push(string);
			}
        }
        if (stack.isEmpty()) return "/";
        for (String string : stack) {
        	stringBuilder.append('/').append(string);
        }
        return stringBuilder.toString();
    }
}