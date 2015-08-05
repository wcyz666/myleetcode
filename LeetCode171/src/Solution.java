
/*
 * return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
 */
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char)(n % 26 + 'A'));
            n = n / 26;
        }
        return sb.reverse().toString();
    }
}