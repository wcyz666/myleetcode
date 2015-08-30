public class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append('1');
        for (int i = 1; i < n; i++) {
            String tmp = sb.toString();
            sb = new StringBuilder();
            for (int j = 0, length = tmp.length(); j < length;) {
                int count = 0;
                char curChar = tmp.charAt(j);
                while (j < length && tmp.charAt(j) == curChar) {
                    j++;
                    count++;
                }
                sb.append(count).append(curChar);
            }
        }
        return sb.toString();
    }
}