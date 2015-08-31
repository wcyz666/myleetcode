public class Solution {
    int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E);
        int right = Math.max(Math.min(C, G), left);
        int bottom = Math.max(B, E);
        int top = Math.max(Math.min(D, H), bottom);
        
        return (C - A) * (D - B) + (H - F) * (G - E) - (right - left) * (bottom - top);
    }
}
