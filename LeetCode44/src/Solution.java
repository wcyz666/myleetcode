public class Solution {
	
/*	﻿﻿﻿
 * O(N^2) time complexity
 * 
 * boolean comparison(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;            
        while (s < str.length()){
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
           // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
           //current pattern pointer is not star, last patter pointer was not *
          //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
}*/
	
	//This solution gets TLE in the last testcase.
	public boolean isMatch(String s, String p) {
		StringBuilder sb = new StringBuilder();
		if (p.length() > 0){
			sb.append(p.charAt(0));
			char prev = p.charAt(0);
			for (int i = 1, length = p.length(); i < length; i++){
				if (prev == '*' && p.charAt(i) == '*')
					continue;
				prev = p.charAt(i);
				sb.append(prev);
			}
		}
	    return _isMatch(0, 0, s, sb.toString());
	}
    
    private boolean _isMatch(int tPos, int rPos, String s, String p) {
        if (tPos == s.length() || rPos == p.length()) {
            if (tPos == s.length() && rPos == p.length())
                return true;
            if (tPos == s.length() && rPos < p.length() && p.charAt(rPos) == '*')
                return _isMatch(tPos, rPos + 1, s, p);
            return false;
        }
        switch (p.charAt(rPos)) {
            case '?':
                return _isMatch(tPos + 1, rPos + 1, s, p);
            case '*': 
	        	if (rPos == p.length() - 1)
	        		return true;
	        	char next = p.charAt(rPos + 1);
	        	int nextPos;
	        	if (next == '?') {
	        	    nextPos = tPos + 1;
	        	    while (nextPos < s.length())
	        	        if (_isMatch(nextPos, rPos + 2, s, p) == false)
	        	            ++nextPos;
	        	        else
	        	            return true;
	        	    return false;
	        	}
	        	nextPos = s.indexOf(next, tPos);
	        	while (nextPos != -1) {
	        		if (_isMatch(nextPos, rPos + 1, s, p) == false)
	        			nextPos = s.indexOf(next, nextPos + 1);
	        		else
	        			return true;
	        	} 
	            return false;
            default :
                return s.charAt(tPos) == p.charAt(rPos) ? _isMatch(tPos + 1, rPos + 1, s, p) : false;
        }     
    }

}