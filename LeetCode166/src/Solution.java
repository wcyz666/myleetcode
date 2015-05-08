import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public String fractionToDecimal(int _numerator, int _denominator) {
        StringBuilder sb = new StringBuilder();
        Map<Long, Integer> hashMap = new HashMap<>();
        List<Long> list = new LinkedList<>();
        long numerator = _numerator, denominator = _denominator;
        int count = 0, startIndex = -1;
        if (numerator % denominator == 0) return (numerator / denominator) + "";
        String flag = numerator * denominator > 0? "": "-";
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        sb.append(flag).append(numerator / denominator).append('.');
        numerator %= denominator;
        
        while (true) {
            numerator *= 10;
            Integer integer = hashMap.put(numerator, count++);
            if (integer != null) {
                startIndex = integer;
            	break;
            }
            if (numerator > denominator){       	
            	list.add(numerator / denominator);
            	if (numerator % denominator == 0)
            		break;
            	numerator %= denominator;
            }
            else
            	list.add(0L);
            
        }
        int i = 0;
        for (Long integer : list) {
        	if (i == startIndex)
        		sb.append('(');
        	sb.append(integer);
        	i++;
        }
        if (startIndex != -1)
        	sb.append(')');
        
        return sb.toString();
        	
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().fractionToDecimal(2,3));
	}
}