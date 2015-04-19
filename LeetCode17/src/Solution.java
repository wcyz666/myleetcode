import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	
	
/*	
 * Another BFS solution using queue
 * 
 * public List<String> letterCombinations(String digits) {
	    LinkedList<String> ans = new LinkedList<String>();
	    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	    ans.add("");
	    for(int i =0; i<digits.length();i++){
	        int x = Character.getNumericValue(digits.charAt(i));
	        while(ans.peek().length()==i){
	            String t = ans.remove();
	            for(char s : mapping[x].toCharArray())
	                ans.add(t+s);
	        }
	    }
	    return ans;
	}
	    */
    static final private Map<Integer, String> map = new HashMap<>();
    static {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }

    private void getAllPermut(List<String> list, String[] table, int current, int length, char[] permu) {
    	for (int i = 0; i < table[current].length(); i++){
    		permu[current] = table[current].charAt(i);
    		if (current == length)
    			list.add(new String(permu));
    		else
    			getAllPermut(list, table, current+1, length, permu);
    	}
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) return list;
        String[] table = new String[digits.length()];
        for (int i = 0; i < digits.length(); i++)
            table[i] = map.get(digits.charAt(i)-'0');
        getAllPermut(list, table, 0, digits.length()-1, new char[digits.length()]);
        return list;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().letterCombinations("23"));
	}
}