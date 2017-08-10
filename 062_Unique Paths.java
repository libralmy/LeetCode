public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     * solution:
     * 1) state: [n-1][m-1]
     * 2) equation: f[n-1][m-1] = [n-2][m-1] + [n-1][m-2]
     * 3) initial & conner case: f[0][0] = 1, f[0][c] = f[r][0] = 1
     * 4) order of calculation: right, then down
     */
    public int uniquePaths(int m, int n) {
        // write your code here 
        int[][] f = new int[m][n];
        
        for(int r = 0; r < m; r++){
            f[r][0] = 1;
        }
        
        for(int c = 0; c < n; c++){
            f[0][c] = 1;
        }
        
        
        for(int r = 1; r < m; r++){
            for(int c = 1; c < n; c++){
                f[r][c] = f[r-1][c] + f[r][c-1];
            }
        }
        
        return f[m-1][n-1];
        
    }
}



/**
* boundery [][]=1
* f[r][c] = f[r-1][c] + f[r][c-1]
* 
***/

public class Solution {
    /*
    public int uniquePaths(int m, int n) {
        if(n < 0 || m <0){return 0;}
        int[][] path = new int[m][n];
        
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n ; c++){
                if(r== 0 || c == 0){
                    path[r][c] = 1;
                    
                }else{
                    path[r][c] = path[r-1][c] + path[r][c-1];
                }
            }
        }
        
        return path[m-1][n-1];
    }
    
    */
    
   public int uniquePaths(int m, int n) {
        if(n < 0 || m <0){return 0;}
        int[] path = new int[n];
        path[0] =1;
        
        for(int r = 0; r < m; r++){
            for(int c = 1; c < n ; c++){
                path[c] += path[c-1];
            }
        }
        
        return path[n-1];
    }
}
