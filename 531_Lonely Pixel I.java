
/**
* use rowCount[] colCount[] to accumulate the amount of B
iterate [][] again to find rowCount[] colCount[] == 1
**/
public class Solution {
    public int findLonelyPixel(char[][] picture) {
        int count = 0;
        
        int m = picture.length, n = picture[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(picture[r][c] == 'B'){
                    rowCount[r]++;
                    colCount[c]++;
                }
            }
        }
        
        
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(picture[r][c] == 'B' && rowCount[r] == 1 && colCount[c] == 1){
                    count++;
                }
            }
        }
        
        return count;
    }
}
