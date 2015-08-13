public class Solution {
    public String getPermutation(int n, int k) {
        int[] facto = new int[10];
        int[] tmp = new int[10];
        String s = "";
        
        facto[0] = 1;
        for (int i = 1; i < 10; i++) {
            facto[i] = i * facto[i - 1];
            tmp[i] = i;
        }
        for (int i = n - 1; i >= 0; i--) {
            int count = (k - 1) / facto[i] + 1;
            k -= (count - 1) * facto[i];
            int j = 0;
            for (int g = 0; g < count; j++) {
                if (tmp[j] != 0)
                    g++;
            }
            s += tmp[--j];
            tmp[j] = 0;
        }
        
        return s;
            
    }
    
    public static void main(String[] args) {

		System.out.println(new Solution().getPermutation(1, 1));
	}
}