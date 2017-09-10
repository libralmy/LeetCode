public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     * initialize f[i][j] = false;
     * f[i][w] = f[i-1][w]|| f[i-1][w-A[i-1]]
     * f[0][0] = true
     * if(j >= A[i-1])
     */
    public int backPack(int m, int[] A) {
        // write your code here
        
        int n = A.length;
        boolean[][] f = new boolean[n+1][m+1];
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = false;
            }
        }

        f[0][0] = true;
        
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= m; j++){
                f[i][j] = f[i-1][j];
                
                if(j >= A[i-1]){
                    f[i][j] = f[i][j] || f[i-1][j-A[i-1]];
                }
            }
        }
        
        
        
        for(int k = m; k >=0 ; k--){
            if(f[n][k]){
                return k;
            }
        }
        
        
        return 0;
    }
}
