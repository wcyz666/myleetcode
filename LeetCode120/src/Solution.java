import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] result = new int[triangle.size()];
        int n = triangle.size();
        int shortest = Integer.MAX_VALUE;
        result[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++){
            result[i] = result[i-1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; j--){
                result[j] = triangle.get(i).get(j) + Math.min(result[j], result[j-1]);
            }
            result[0] += triangle.get(i).get(0);
        }
        for (int i = 0; i < n; i++)
            if (shortest > result[i])
                shortest = result[i];
        return shortest;
    }
}