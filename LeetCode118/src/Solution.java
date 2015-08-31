import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>(); 
            if (i == 1) {
                list.add(1);
            }
            else {
                list.add(1);
                List<Integer> prev = lists.get(i - 2);
                for (int j = 0, length = prev.size() - 1; j < length; j++)
                    list.add(prev.get(j) + prev.get(j + 1));
                list.add(1);
            }
            lists.add(list);
            
        }
        return lists;
    }
}