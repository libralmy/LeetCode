/**
* @param a given grid
* @return the whole island perimeter
* -> right and | down, so if detect a island, then means it lost two shared edges
***/
public class Solution {
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        if(grid == null || grid.length == 0){return result;}
        
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 1){
                    result +=4;
                    
                    if(r < grid.length-1 && grid[r+1][c] == 1){result -= 2;}
                    if(c < grid[0].length-1 && grid[r][c+1] == 1){result -= 2;}
                }
                
                
            }
        }
        
        return result;
    }
}
