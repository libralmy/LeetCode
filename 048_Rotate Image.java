
    
    /**
    * @param matrix a given 2d int array
    * @return reverse 90degree
    * 
    * symmetrically \ upper left 
    * [row,col]=> [col, row]
    * row<n, col<n
    * 
    * vertically | left to right
    * [row,col]=>[row, n-col-1]
    * row<n/2, col<n
    **/
public class Solution {    
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n == 0){return;}
        for(int row = 0; row < n; row++){
            for(int col = row; col < n; col++){ //col =0, col<row
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] =temp;
                //swap(matrix[row][col], matrix[col][row]);
            }
        }
        
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n/2; col++){
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][n-col-1];
                matrix[row][n-col-1] =temp;
                
                //swap(matrix[row][col], matrix[row][n-col-1]);
            }
        }
        
    }
    
    public void swap(int a, int b){
        int temp = 0;
        temp = a;
        a = b;
        b = temp;
    }

}
