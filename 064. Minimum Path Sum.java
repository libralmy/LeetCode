public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     * sum[i][0] = sum[i-1][0] + grid[i][0]
     *  sum[0][j] = sum[0][j-1] + grid[0][j]
     * sum[i][j] = Math.min(sum[i-1][j], sum[i][j-1]) + grid[i][j]
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];
        sum[0][0] = grid[0][0];
        
        for(int i = 1; i < m; i++){
            sum[i][0] = sum[i-1][0] + grid[i][0];
        }
        
        for(int j = 1; j < n; j++){
            sum[0][j] = sum[0][j-1] + grid[0][j];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                sum[i][j] = Math.min(sum[i-1][j], sum[i][j-1]) + grid[i][j];
            }
            
        }
        
        
        return sum[m-1][n-1];
        
    }
}



/**
* grid[r][c] += Math.min(grid[r][c-1], grid[r-1][c])
**/
public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0|| grid[0].length == 0){
            return 0;
        }
        
        for(int r = 0; r < grid.length ; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(r != 0 && c != 0){
                    grid[r][c] += Math.min(grid[r-1][c], grid[r][c-1]);
                }else if(r == 0 && c != 0){
                    grid[r][c] += grid[r][c-1];
                }else if(r != 0 && c == 0){
                    grid[r][c] += grid[r-1][c];
                }else{
                    grid[r][c] = grid[r][c];
                }
            }
        }
        
        return grid[grid.length-1][grid[0].length-1];
    }
}
