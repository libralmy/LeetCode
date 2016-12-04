
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
