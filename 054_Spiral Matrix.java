public class Solution {
    /**
    * @param matirx 2D int array
    * @return int list in spiral order of matrix
    * S1
    * -> colBegin++  | rowBegin++
    * <- colEnd--   | rowEnd--
    * while(col/row Begin<= col/row End)
    * whether the row or col still exists to prevent duplicates if(rowEnd >= rowBegin) for<- [2, 3]
    * if(colEnd >= colBegin) 2
    * S2:                       3
    * while(true)
    * top -> | right  
    * <- bottom | left
    * each step : if(left > right || top > bottom) break;
    **/
    public List<Integer> spiralOrder(int[][] matrix) {
        /*
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length ==0)return result;
        
        int rowBegin = 0, rowEnd = matrix.length-1;
        int colBegin = 0, colEnd = matrix[0].length-1;
        
        while(rowBegin <= rowEnd && colBegin <= colEnd){
            for(int i = colBegin; i <= colEnd; i++){
                result.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            
            for(int i = rowBegin; i <= rowEnd; i++){
                result.add(matrix[i][colEnd]);
            }
            colEnd--;
            //whether the row or col still exists to prevent duplicates
            if(rowEnd >= rowBegin){
                for(int i = colEnd; i>= colBegin; i--){
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            if(colEnd >= colBegin){
                for(int i = rowEnd; i >= rowBegin; i--){
                    result.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }
        return result;
        */
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length == 0 || matrix[0].length == 0) return res;
        
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        
        while(true){
            for(int i = left; i <= right; i++) res.add(matrix[top][i]);
            top++;
            if(left > right || top > bottom) break;
            
            for(int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            right--;
            if(left > right || top > bottom) break;
            
            for(int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            bottom--;
            if(left > right || top > bottom) break;
            
            for(int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            left++;
            if(left > right || top > bottom) break;
        }
        
        return res;
    }
}
