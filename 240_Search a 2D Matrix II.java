
    /**
    * @param matrix - 2D int array
    * @param target - the one need to be verified
    * @return boolean - find it in array or not
    * 
    * 
    *       smaller
    * smaller x    greater
    *       greater
    * top right conner <- col --, | row++
    * if[][] < target, row++
    * [][] > target, col-- 
    * [][] == target return true
    * 
    * return false
    **/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){return false;}
        int row = 0;
        int col = matrix[0].length -1;
        
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){//<-
                col--;
            }else{//|
                row++;
            }
        }
        
        
        return false;
    }
}
