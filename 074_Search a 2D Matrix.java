
    /**
    * @param a given sorted 2D int array
    * @param target 
    * @return is the target in the array or not
    * it is a sorted array, so could use binary search
    * row = matrix.length, col = matrix[0].length
    * start = 0, end = row*col-1 while(start<=end)
    * mid = start +(end - start)/2
    * matrix[mid/col][mid%col] ~ target 
    * < start = mid+1, > end = mid-1
    **/
  public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length ==0 || matrix[0].length == 0){return false;}
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0, end = row*col - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            int mid_val = matrix[mid/col][mid%col];
            if(mid_val == target){
                return true;
            }else if(mid_val < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        return false;
    }
}
