public class Solution {
    public int numDecodings(String s) {
        
        int length = s.length();
        
        if (length == 0) return 0;
        
        int[] result = new int[length + 1];
        
        result[0] = 1;
        result[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for (int i = 2; i <= length; i++) {
            char cur = s.charAt(i - 1);
            char prev = s.charAt(i - 2);
            if (prev >= '3' && cur == '0') return 0;
            int flag = (prev == '1' || (prev == '2' && cur <= '6')) ? result[i - 2] : 0;
            int flag1 = (cur == '0') ? 0: result[i - 1];
            result[i] = flag + flag1;
        }
        return result[length];
    }
}