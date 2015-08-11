/*
 * class Solution {
public:
    int trap(int A[], int n) {
        int left=0; int right=n-1;
        int res=0;
        int maxleft=0, maxright=0;
        while(left<=right){
            if(A[left]<=A[right]){
                if(A[left]>=maxleft) maxleft=A[left];
                else res+=maxleft-A[left];
                left++;
            }
            else{
                if(A[right]>=maxright) maxright= A[right];
                else res+=maxright-A[right];
                right--;
            }
        }
        return res;
    }
};
 */

public class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        for (; left < right && height[left] <= height[left + 1]; left++);
        for (; left < right && height[right] <= height[right - 1]; right--);
        return _trap(height, left, right);
    }
    private int _trap(int[] height, int left, int right) {
        if (left >= right - 1)
            return 0;
        else {
            int count = 0, pos = -1;
            int lVal = height[left], rVal = height[right], min = Math.min(lVal, rVal), max = min;
            for (; left < right && height[left] == height[left + 1]; left++);
            for (int i = left + 1; i < right; i++) {
                if (height[i] > max) {
                    pos = i;
                    max = height[pos];
                }
                else {
                    count += - height[i] + min;
                }
            }
            if (pos == -1)
                return count;
            else
                return _trap(height, left, pos) + _trap(height, pos, right);
        }
    }
}