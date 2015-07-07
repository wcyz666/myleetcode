public class Solution {
    public String addBinary(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int flag = 0, i, j;
        for (i = num1.length() - 1, j = num2.length() - 1; i >= 0 && j >= 0; i--, j--) {
            int sum = num1.charAt(i) - '0' + num2.charAt(j) - '0' + flag;
            flag = sum / 2;
            sb.append(sum % 2);
        }
        for (; i >=0; i--) {
            int sum = num1.charAt(i) - '0' + flag;
            flag = sum / 2;
            sb.append(sum % 2);               
        }
        for (; j >=0; j--) {
            int sum = num2.charAt(j) - '0' + flag;
            flag = sum / 2;
            sb.append(sum % 2);               
        }
        if (flag != 0)
            sb.append(flag);
        sb.reverse();
        return sb.toString();
    }

}