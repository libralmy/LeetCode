
public class Solution {
    /*
     * @param n: a positive integer
     * @return: An integer
     Arrays.fill(f, Integer.MAX_VALUE);
     initiate f[i*i] = 1
     j=1 f[i] = min(1 <= j*j <= i)f[i-j2] +1
     */
    public int numSquares(int n) {
        // write your code here
        
        
        int[] f = new int[n+1];
        Arrays.fill(f, Integer.MAX_VALUE);
        
        for(int i = 0; i*i <= n; i++){
            f[i*i] = 1;
        }
        
        
        for(int i = 0; i <= n; i++){
            for(int j = 1; j*j<= i; j++){
                f[i] = Math.min(f[i], f[i-j*j] +1);
            }
        }
        
        return f[n];
    }
}
