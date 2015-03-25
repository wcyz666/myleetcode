public class Solution {
    public String convert(String s, int nRows) {
        if (nRows == 1 || s.length() < nRows)
        	return s;
        
        StringBuilder[] sBuilders = new StringBuilder[nRows];
        StringBuilder sResult = new StringBuilder();

        int oneIteration = 2 * (nRows - 1);
        for (int i = 0; i < nRows; i++){
        	sBuilders[i] = new StringBuilder();
        }
        
        for (int i = 0; i < s.length() / oneIteration; i++){
        	sBuilders[0].append(s.charAt(i * oneIteration));
        	for (int j = 1; j < nRows - 1; j++){
        		sBuilders[j].append(s.charAt(i * oneIteration + j))
        		.append(s.charAt((i + 1) * oneIteration - j));
        	}
        	sBuilders[nRows - 1].append(s.charAt(i * oneIteration + nRows - 1));
        }

        int remain = s.length() % oneIteration;
        if (remain <= nRows){
	    	for (int i = 0; i < remain; i++){
	    		sBuilders[i].append(s.charAt(s.length() / oneIteration * oneIteration + i));
	    	}
        }
        if (remain > nRows){
        	for (int i = 0; i < nRows; i++){
	    		sBuilders[i].append(s.charAt(s.length() / oneIteration * oneIteration + i));
	    	}
        	for (int i = 0; i < remain - nRows; i++){
        		sBuilders[nRows - 2 - i].
        		append(s.charAt(s.length() / oneIteration * oneIteration + nRows + i));
        	}
        }
        for (StringBuilder sTemp : sBuilders){
        	sResult.append(sTemp);
        }
        return sResult.toString();
    }
    
    public static void main(String[] args) {
    	System.out.println(new Solution().convert("PAYPALISHIRING", 3));
		System.out.println(new Solution().convert("ABC", 2));
		System.out.println(new Solution().convert("ABCDE", 4));
		System.out.println(new Solution().convert("PAYPALISHIRING", 9));
	}
}