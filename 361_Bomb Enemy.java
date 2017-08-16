public class Solution {
    /**
     * @param grid Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] A) {
        //  up[i][j] =0
        // up[i][j]!='W'  up[i][j]=='E', up[i-1][j]=1; i>1 up[i][j]+= up[i-1][j] 
        //if(A[i][j] == '0') find out max sum of four direction 
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }

        int m = A.length;
        int n = A[0].length;
        
        int[][] up  = new int[m][n];
        for(int i =0; i < m; i++){
            for(int j = 0; j < n; j++){
                up[i][j] = 0;
                if(A[i][j] != 'W'){

                    if(A[i][j] =='E'){
                        up[i][j] = 1;
                    }
                
                    if(i > 0){
                        up[i][j] += up[i-1][j];
                    }
                }
            }
            
        }
        
        
        int[][] down  = new int[m][n];
        for(int i = m-1; i >= 0; i--){
            for(int j = 0; j < n; j++){
                down[i][j] = 0;
                if(A[i][j] != 'W'){

                    if(A[i][j] =='E'){
                        down[i][j] = 1;
                    }
                
                    if(i < m-1){
                        down[i][j] += down[i+1][j];
                    }
                    
                }
            }
            
        }
        
        
        
        int[][] left  = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                left[i][j] = 0;
                if(A[i][j] != 'W'){
                
                    if(A[i][j] =='E'){
                        left[i][j] = 1;
                    }
                
                    if(j > 0){
                        left[i][j] += left[i][j-1];
                    }
                    
                }
            }
            
        }
        
        int[][] right  = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = n-1; j >= 0; j--){
                right[i][j] = 0;
                if(A[i][j] != 'W'){

                    if(A[i][j] =='E'){
                        right[i][j] = 1;
                    }
                
                    if(j+1 < n){
                        right[i][j] += right[i][j+1];
                    }
                    
                }
            }
            
        }
        
        int result = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(A[i][j] == '0'){
                    result = Math.max(result, up[i][j] + down[i][j] + left[i][j] + right[i][j]);
                }
            }
        }
        
        return result;
    }
}
