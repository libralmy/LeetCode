public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     * solution: 1) state: boolean[A.length]
     * 2) transformal state equation: boolean[inbound] && A[inbound]+inbound >= outbound
     * 3) initial & conner case: boolean[0] = true; outbound start from 1
     * 4) order of calculation: outbound -> inbound
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        int n = A.length;
        boolean[] f = new boolean[n];
        f[0] = true;
        
        for(int outbound = 1; outbound < n; outbound++){
            f[outbound] = false;
            for(int inbound = 0; inbound < outbound; inbound++){
                if(f[inbound] && A[inbound]+inbound >= outbound){
                    f[outbound] = true;
                    break;
                }
                
                
            }
        }
        
        
        return f[n-1];
    }
}
