/*
 * An algorithm using BitSet 
 * 
 * public int countPrimes(int n) {
    BitSet bs = new BitSet(n);
    bs.set(0); bs.set(1);
    int ind = 0, count = 0;
    while(ind < n){
        ind = bs.nextClearBit(ind + 1);
        if(ind >= n)
            return count;
        count++;
        for(int i = 2 * ind; i < n; i += ind)
            bs.set(i);
    }
    return count;
}*/
public class Solution {
    public int countPrimes(int n) {
        int[] A = new int[n];
        int count = 0;
        for (int i = 2; i < n; i++)
            A[i] = 1;
        for (int i = 2; i < n; i++)
            if (A[i] != 0) {
                int a = i * 2;
                while (a < n) {
                    A[a] = 0;
                    a += i;
                }
            }
        for (int i = 2; i < n; i++)
            if (A[i] != 0)
                ++count;
        return count;
    }
}