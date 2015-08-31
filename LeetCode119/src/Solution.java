import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0)
            return list;
        else
            if (rowIndex == 0) {
                list.add(1);
                return list;
            }
            else {
                list.add(1);
                BigInteger comNum = new BigInteger("1");
        
                for (int i = 0; i < rowIndex; i++) {
                	long tmp = comNum * (rowIndex - i);
                    comNum = (int)(tmp / (i + 1)); 
                    list.add(comNum);
                }
                return list;
            }
    }
    public static void main(String[] args) {
		System.out.println(new Solution().getRow(15));
	}
}