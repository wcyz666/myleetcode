import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    
    private List<List<Integer>> lists;
    private Integer[] array;   
    
    public List<List<Integer>> combine(int n, int k) {
        lists = new LinkedList<>();
        array = new Integer[k];
        calculateCom(1, 0, n, k);
        return lists;
    }
    
    private void calculateCom(int curNum, int curPos, int n, int k) {
        for (int i = curNum; i <= n; i++) {
            array[curPos] = i;
            if (curPos + 1 == k) {
                lists.add(new ArrayList<Integer>(Arrays.asList(array)));
            }
            else
                calculateCom(i + 1, curPos + 1, n, k);
        }
    }
}