import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isHappy(int n) {
        Map<Integer, Boolean> maps = new HashMap<>();
        for (; ;) {
            int tmp = 0;
            while (n > 0) {
                tmp += (n % 10) * (n % 10);
                n /= 10;
            }
            if (tmp == 1)
                return true;
            if (maps.put(tmp, true) != null)
                return false;
        }
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().isHappy(7));
	}
}