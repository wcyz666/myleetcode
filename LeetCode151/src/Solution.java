public class Solution {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        if (strings.length < 1) return "";
        if (s.indexOf(' ') == -1) return s;
        for (int i = 0, j = strings.length - 1; i < j; i++, j--) {
        	String tmp = strings[i];
        	strings[i] = strings[j];
        	strings[j] = tmp;
        }
        StringBuilder sBuilder = new StringBuilder();
        for (String string : strings)
        	if (string.length() >= 1)
        		sBuilder.append(string).append(' ');
        sBuilder.deleteCharAt(sBuilder.length() - 1);
        return sBuilder.toString();
    }
}