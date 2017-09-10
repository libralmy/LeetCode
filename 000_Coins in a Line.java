public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     * f[0] = false  f[1] = true f[2] = true;
     *          next player
     *         f[i-1]  f[i-2]
     * f[i]=T     F       F
     * f[i]=T     F       T
     * f[i]=T     T       F
     * f[i]=F     T       T
     */
    public boolean firstWillWin(int n) {
        // write your code here
        if(n == 0){
            return false;
        }else if(n == 1 || n== 2){
            return true;
        }
        
        boolean[] f = new boolean[n+1];
        f[0] = false;
        f[1] = true;
        f[2] = true;
        
        for(int i = 3; i <= n; i++){
            f[i] = !f[i-1] || !f[i-2];

        }

        return f[n];
    }
}
