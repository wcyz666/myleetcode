public class Solution {
    
    int numTrees(int n) {
        
        if (n == 0) return 0;
        int[] trees = new int[n + 1];
        trees[0] = 1;
        int a = 1;
        for(int i = 1; i <= n; i++) 
            for (int j = 0; j < i; j++) 
                trees[i] += trees[j] * trees[i-j-1];
    
        return trees[n];
    } 
}