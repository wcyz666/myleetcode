public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() == 0) return -1;
        for (int i = 0, length = haystack.length() - needle.length(); i < length + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 1;
                for (; j < needle.length() && haystack.charAt(j + i) == needle.charAt(j); j++);
                if (j == needle.length())
                    return i;
            }
        }
        return -1;
    }
}