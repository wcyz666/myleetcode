public class Solution {
    public int[] plusOne(int[] digits) {
        
        int length = digits.length;
        if (length == 0) return digits;
        
        digits[length - 1] += 1;
        if (digits[length - 1] < 10) {
            return digits;
        }
        digits[length - 1] = 0;
        
        for (int i = length - 2; i >= 0; i--){
            digits[i]++;
            if (digits[i] < 10)
                return digits;
            else
                digits[i] = 0;
        }
        if (digits[0] == 0) {
            int[] result = new int[length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }
}