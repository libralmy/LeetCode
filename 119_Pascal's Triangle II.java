/**
* list as the output, so Integer[rowIndex+1] result[0]=1
* result[j] += result[j-1];
**/

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] result = new Integer[rowIndex+1];
        Arrays.fill(result, 0);
        if(rowIndex < 0){return Arrays.asList(result); }
        
        result[0] = 1;
        for(int i = 1; i <= rowIndex; i++){
            for(int j = i; j >= 1; j--){
                result[j] += result[j-1];
            }
        }
        
        
        return Arrays.asList(result);
    }
}
