public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaofA = (C-A) * (D-B);
        int areaofB = (G-E) * (H-F);
        
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        
        int overlap= 0;
        if(left < right && top > bottom){
            overlap = (right - left) * (top-bottom);
        }
        
        return areaofA + areaofB - overlap;
    }
}
