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
                int comNum = 1;
                for (int i = 0; i < rowIndex; i++) {
                	long tmp = comNum * (rowIndex - i);
                    comNum = (int)(tmp / (rowIndex + 1)); 
                    list.add(comNum);
                }
                return list;
            }
    }

}