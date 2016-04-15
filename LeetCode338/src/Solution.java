import java.util.Arrays;

public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        int power = 1;
        int iteration = 0;
        for (int i = 1; i <= num; i++) {
            if (iteration < power) {
                iteration++;
            } else {
                power *= 2;
                iteration = 0;
            }
            result[i] = result[i - power] + 1;
        }
        return result;
    }
    public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution().countBits(4)));
	}
}