public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String s = "";
        int shortest = Integer.MAX_VALUE;
        for (String str : strs){
            if (shortest > str.length())
                shortest = str.length();
        }
        for (int i = 0; i < shortest; i++){
            char now = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++)
                if (now != strs[j].charAt(i))
                    return s;
            s += now;
        }
        return s;
    }
}