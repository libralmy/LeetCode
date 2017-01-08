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
