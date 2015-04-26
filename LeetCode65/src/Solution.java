public class Solution {

    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) return false;
        if (s.indexOf(".e") != -1)
        	return s.matches("[+-]?\\d+\\.e[+-]?\\d+");
        if (s.indexOf('e') != -1){
            if (s.indexOf('.') != -1)
                return s.matches("[+-]?\\d*\\.\\d+e[+-]?\\d+");
        	return s.matches("[+-]?\\d+e[+-]?\\d+");
        }

        return !s.matches("[^\\d]++") && s.matches("[+-]?\\d*(\\.\\d*)?");
    }
}