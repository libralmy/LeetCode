public class Solution {
    /*
     * @param prices: Given an integer array
     * @return: Maximum profit
     1, 3, 5 Math.max(f[i-1][j], f[i-1][j-1] + p[i-1]-p[i-2])
     2, 4   Math.max(f[i-1][j]+ p[i-1]-p[i-2], f[i-1][j-1])
     answer Math.max(f[n][1], f[n][3], f[n][5])
     */
    public int maxProfit(int[] p) {
        // write your code here
        int K = 2; //at most two transactions
        int n = p.length;
        
        int[][] f = new int[n+1][2*K+1+1];
        
        for(int i = 0; i <= n ; i++){
            for(int j = 1; j <= 2*K+1; j++){
                f[i][j] = Integer.MIN_VALUE;
            }
        }
        
        int result = 0;
        
        f[0][1] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= 2*K+1; j+=2){
                f[i][j] = getUpdate(f[i][j], f[i-1][j], 0);
                if(i>1 && j>1) f[i][j] = getUpdate(f[i][j], f[i-1][j-1], p[i-1]-p[i-2]);
            }
            
            
            for(int j = 2; j <= 2*K; j+=2){
                
                if(i>1) f[i][j] = getUpdate(f[i][j], f[i-1][j], p[i-1]-p[i-2]);
                
                if(j>1) f[i][j] = getUpdate(f[i][j], f[i-1][j-1], 0);
            }
        }
        

        for(int j = 1; j <= 2*K+1; j+=2){
            result = getUpdate(result, f[n][j], 0);
        }
   
        
        return result;
    }
    
    
    
    public int getUpdate(int a, int b, int delta){
        if(b == Integer.MIN_VALUE){
            return a;
        }
        
        if(b+delta > a){
            return b+delta;
        }
        
        return a;
    }
}
