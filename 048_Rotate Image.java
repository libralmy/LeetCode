public class Solution {
    /**
    * @param 2D matrix
    * @return rotate the matrix by 90 degree 
    * 
    * if go swift, then all the point needs to be moved, 2mn
    * so if could make find the axil to do the flip over, it will be mn/4
    * rotate -180 and reverse -90 => upper right to bottom left, then left to right
    * -180 degree => col=row
    * for(row< length )
    *   for(col=row  col< length )
    *       swap(m[row][col], m[col][row])
    * 
    * -90 degree
    * for(row < len)
    *   for(col < len/2 )
    *       swap(m[row][col], m[row][len -col-1])
    **/
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){return;}
        int len = matrix[0].length;
        
        for(int row = 0; row < len; row++){
            for(int col = row; col < len; col++){
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
        
        
        for(int row = 0; row < len; row++){
            for(int col = 0; col < len/2; col++){
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][len - 1- col];
                matrix[row][len-1-col] = temp;
            }
        }
    }
}
