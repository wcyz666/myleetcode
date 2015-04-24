public class Solution {
    public boolean isMatch(String s, String p) {
        return _isMatch(0, 0, s, p);
    }
    
    private boolean _isMatch(int tPos, int rPos, String s, String p) {
    	//boundary checking
        if (tPos == s.length() || rPos == p.length()) {
            if (tPos == s.length() && rPos == p.length())
                return true;
            //The following is used to check "aaaa", "aaaaa*a*"
            if (tPos == s.length() && rPos < p.length() - 1 && p.charAt(rPos + 1) == '*')
                return _isMatch(tPos, rPos + 2, s, p);
            //match failed
            return false;
        }
        //not match at current position, if no *, then match failed
        //Otherwise we can skip the current * in the regex and continue
        //to next match.
        if (s.charAt(tPos) != p.charAt(rPos) && p.charAt(rPos) != '.') {
        	//no *, match failed
            if (rPos == p.length() - 1 || p.charAt(rPos + 1) != '*') 
                return false;
            //skip the *
            return _isMatch(tPos, rPos + 2, s, p);
        }
        //match at current position, if no *, then continue to match the next
        //position both in text and regex.
        //Otherwise try to match one more chars and provide states for backtrack
        if (rPos == p.length() - 1 || p.charAt(rPos + 1) != '*') 
            return _isMatch(tPos + 1, rPos + 1, s, p);

        return _isMatch(tPos + 1, rPos, s, p) || _isMatch(tPos, rPos + 2, s, p);
    }
}