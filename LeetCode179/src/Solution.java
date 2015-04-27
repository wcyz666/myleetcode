import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    
    private static final Comparator<String> comparator = new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			String a1 = o1 + o2;
			String a2 = o2 + o1;
			for(int i = 0, max = a1.length(); i < max; i++){
				if (a1.charAt(i) > a2.charAt(i))
					return -1;
				if (a1.charAt(i) < a2.charAt(i))
					return 1;
			}
			return 0;
		}
	};

    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0, length = nums.length; i < length; i++)
            strings[i] = nums[i] + "";
        Arrays.sort(strings, comparator);
        if (strings[0].charAt(0) == '0') return "0";
        StringBuilder builder = new StringBuilder();
        for(String s : strings) {
            builder.append(s);
        }
        return builder.toString();
    }
    
    
}