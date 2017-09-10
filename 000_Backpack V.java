public class Solution {
    /*
     * @param nums: an integer array and all positive numbers
     * @param target: An integer
     * @return: An integer
     f[0][0] = 1
     * f[i][j] = f[i-1][j] + f[i-1][j-A[i-1]]
     */
    public int backPackV(int[] A, int m) {
        // write your code here
        int n = A.length;
        /*
        int[][] f = new int[n+1][m+1];
        f[0][0] = 1;
        
        
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= m; j++){
                f[i][j] += f[i-1][j];
                
                if(j >= A[i-1]){
                    f[i][j] += f[i-1][j-A[i-1]];
                }
            }
        }
        return f[n][m];
        */
        
        int[] f = new int[m+1];
        f[0] =1;
        for(int i = 0; i < n ; i++){
            for(int j = m; j>= A[i]; j--){
                f[j] += f[j - A[i]];
            }
        }
        return f[m];
        
        
    }
}
