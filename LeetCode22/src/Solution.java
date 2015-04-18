import java.util.ArrayList;
import java.util.List;


public class Solution {
	
/*	Another Algorithm using recursive backtracking 
 * 
 * public List<String> generateParenthesis(int n) {
	        List<String> list = new ArrayList<String>();
	        backtrack(list, "", 0, 0, n);
	        return list;
	    }

	    public void backtrack(List<String> list, String str, int open, int close, int max){

	        if(str.length() == max*2){
	            list.add(str);
	            return;
	        }

	        if(open < max)
	            backtrack(list, str+"(", open+1, close, max);
	        if(close < open)
	            backtrack(list, str+")", open, close+1, max);
	    }*/
	
	public List<String> generatePan(int n){
		List<String> list = new ArrayList<>();
		if (n == 0) return list;
		int[] result = new int[n];
		for (int i = 0; i < n; i++)
			result[i] = 1;
		result[0] = 1;
		int begin = 1;
		do {
			result[begin]++;
			if (result[begin] <= 2 * n){
				if (begin == n - 1)
					if (isValid(result))
						list.add(toParensisString(result));
					else{
						result[begin] = result[begin-1];
						begin--;		
					}
				else {
					begin++;
					result[begin] = result[begin-1];
				}
			}
			else {
				result[begin] = result[begin-1];
				begin--;
			}
		} while (begin != 0);
		
		return list;
	}
	
	private String toParensisString(int[] result) {
		// TODO Auto-generated method stub
		
		char[] charParensis = new char[result.length*2];
		for (int i = 0; i < charParensis.length; i++)
			charParensis[i] = ')';
		for (int i = 0; i < result.length; i++)
			charParensis[result[i] - 1] = '(';
		return new String(charParensis);
	}

	private boolean isValid(int[] result) {
		int current = 0;
		int j = 0;
		for (int i = 1; i <= 2 * result.length; i++){
			if (i == result[j]){
				j++;
				current++;
				if (j == result.length)
					return true;
			}
			else {
				current--;
				if (current < 0)
					return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(new Solution().generatePan(10));
		
	}
}
