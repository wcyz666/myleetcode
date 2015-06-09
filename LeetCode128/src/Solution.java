import java.util.HashMap;
import java.util.Map;

public class Solution {
    
    private class Linker {
        public Linker next;
        public int tag;
        
        public Linker(){
            this.tag = 0;
            this.next = null;
        }
    }
    
    
    public int longestConsecutive(int[] nums) {
        
        Map<Integer, Linker> numMap = new HashMap<>(nums.length);
        
        for (int integer : nums) {
    
            Linker left = numMap.get(integer - 1);
            Linker right = numMap.get(integer + 1);
            Linker cur = new Linker();
            if (left != null) {
                left.next = cur;
            }
            cur.next = right;
            numMap.put(integer, cur);
        }
        
        int max = 0;
        
        for (Linker cw : numMap.values()) {
            if (cw.tag == 0) {
                int curCount = 0;
                while (cw != null) {
                    cw.tag = 1;
                    cw = cw.next;
                    ++curCount;
                }
                if (curCount > max)
                    max = curCount;
            }
        }
        
        return max;
    }
}