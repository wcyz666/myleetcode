import java.util.ArrayList;
import java.util.List;

public class Solution {
    class Counter {
        int num;
        int netCount;
    }
    public List<Integer> majorityElement(int[] nums) {
        int length = nums.length;
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();       
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if (counter1.netCount == 0) {
                counter1.num = i;
                counter1.netCount = 1;
            }
            else if (counter1.num == i) {
                ++counter1.netCount;
            }
            else if (counter2.netCount == 0) {
                counter2.num = i;
                counter2.netCount = 1;
            }
            else if (counter2.num == i) {
                ++counter2.netCount;
            }
            else {
                --counter1.netCount;
                --counter2.netCount;
            }
        }
        if (counter1.netCount > 0){
            int count = 0;
            for (int i : nums) {
                if (i == counter1.num)
                    ++count;
            }
            if (count > length / 3)
                list.add(counter1.num);
        }
        if (counter2.netCount > 0 && counter1.num != counter2.num) {
            int count = 0;
            for (int i : nums) {
                if (i == counter2.num)
                    ++count;
            }
            if (count > length / 3)
                list.add(counter2.num);
        }
        return list;
    }
}