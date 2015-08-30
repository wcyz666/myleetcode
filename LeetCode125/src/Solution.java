public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            
            while (i < j && !Character.isDigit(s.charAt(i)) && !Character.isAlphabetic(s.charAt(i)))
                i++;
            while (i < j && !Character.isDigit(s.charAt(j)) && !Character.isAlphabetic(s.charAt(j)))
                j--;
            if (i < j && s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
}