
/**
* flagr flagc for checking first row and first col
* make the second row and col as the flag
* recheck the first row and col
**/

public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){return;}
        boolean fr = false, fc = false;
        
        for(int r = 0 ; r < matrix.length ; r++){
            for(int c = 0; c < matrix[0].length; c++){
                if(matrix[r][c] == 0){
                    if(r == 0){fr = true;}
                    if(c == 0){fc = true;}
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                    
                }
            }
        }
        
        for(int r = 1 ; r < matrix.length ; r++){
            for(int c = 1; c < matrix[0].length; c++){
                if(matrix[r][0] == 0 || matrix[0][c] == 0 ){
                    matrix[r][c] = 0;
                    
                }
            }
        }
        
        if(fr){
            for(int c = 0; c < matrix[0].length; c++){
                    matrix[0][c] = 0;
            }
        }
        
        if(fc){
            for(int r = 0; r < matrix.length; r++){
                    matrix[r][0] = 0;
            }        
        }
    }
}



public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0){return;}
        boolean[] rZero = new boolean[matrix.length];
        boolean[] cZero = new boolean[matrix[0].length];
        
        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[0].length; c++){
                if(matrix[r][c] == 0){
                    rZero[r] = true;
                    cZero[c] = true;
                }
            }
        }

        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[0].length; c++){
                if(rZero[r] || cZero[c]){
                    matrix[r][c] = 0;
                    
                }
            }
        }

    }
}
