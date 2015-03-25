import java.util.Stack;

public class Solution {
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