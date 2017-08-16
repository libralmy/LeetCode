public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] A) {
        // write your code here
        //f[i][j] = f[i-1][j] + f[i][j-1]
        // [i][j] = 1 => f[i][j] = 0
        // i=0 & j=0 f[i][j]=1
        // i=0 f[i][j] = f[i][j-1]
        // j=0 f[i][j] = f[i-1][j]
        if(A == null || A.length == 0 || A[0].length == 0){return 0;}
        
        int m = A.length;
        int n = A[0].length;
        int[][] f = new int[m][n];

        
        for(int i = 0 ; i < m; i++){
           
            for(int j = 0; j < n; j++){
                
                if(A[i][j] == 1){
                    f[i][j] = 0;
                    continue;
                }
                
                if(i == 0 && j == 0){
                    f[i][j] = 1;
                    continue;
                }    
                
                if(i == 0){
                    f[i][j] = f[i][j-1];
                    continue;
                }
                
                if(j == 0){
                    f[i][j] = f[i-1][j];
                    continue;
                }
                
                f[i][j] = f[i-1][j] + f[i][j-1];
                
                
            }
        }
        
    
    
    return f[m-1][n-1];
    }
}

/**
* for start from(0,0)
* if[][] = 1 then path[] = 0
***/

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){return 0;}
        
        int[] path = new int[obstacleGrid[0].length];
        path[0] = 1;
        for(int r = 0; r < obstacleGrid.length; r++){
            for(int c = 0; c < obstacleGrid[0].length; c++){
                if(obstacleGrid[r][c] == 1){
                    path[c] = 0;
                }else{
                    if(c>0){
                        path[c] += path[c-1];
                        
                    }
                }
            }
        }
        
        return path[obstacleGrid[0].length-1];
    }
}
