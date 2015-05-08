public class Solution {
    public String multiply(String num1, String num2) {
        String result = "0";
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0')
            return "0";
        for (int i = num2.length() - 1, length = num2.length() - 1; i >= 0; i--) {
            result = add(result, multiplyWithChar(num1, num2.charAt(i), length - i));
        }
        return result;   
    }
    
    private String add(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int flag = 0, i, j;
        for (i = num1.length() - 1, j = num2.length() - 1; i >= 0 && j >= 0; i--, j--) {
            int sum = num1.charAt(i) - '0' + num2.charAt(j) - '0' + flag;
            flag = sum / 10;
            sb.append(sum % 10);
        }
        for (; i >=0; i--) {
            int sum = num1.charAt(i) - '0' + flag;
            flag = sum / 10;
            sb.append(sum % 10);               
        }
        for (; j >=0; j--) {
            int sum = num2.charAt(j) - '0' + flag;
            flag = sum / 10;
            sb.append(sum % 10);               
        }
        if (flag != 0)
            sb.append(flag);
        sb.reverse();
        return sb.toString();
    }
    
    private String multiplyWithChar(String num1, char ch, int shift) {
        int flag = 0, multiplier = ch - '0';
        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) {
            int product = (num1.charAt(i) - '0') * multiplier + flag;
            flag = product / 10;
            sb.append(product % 10);
        }
        if (flag != 0)
            sb.append(flag);
        sb.reverse();
        for (int i = 0; i < shift; i++)
            sb.append(0);
            
        return sb.toString();
    }
}