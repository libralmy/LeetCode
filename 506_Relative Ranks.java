/**
*
Example:

nums[i]    : [10, 3, 8, 9, 4]
pair[i][0] : [10, 3, 8, 9, 4]
pair[i][1] : [ 0, 1, 2, 3, 4]

After sort:
pair[i][0] : [10, 9, 8, 4, 3]
pair[i][1] : [ 0, 3, 2, 4, 1]
***/

public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        String[] result = new String[nums.length];
        
        if(nums == null || nums.length == 0){return result;}
        int[][] counter = new int[nums.length][2];
        
        for(int i = 0; i < nums.length; i++){
            counter[i][0] = nums[i];
            counter[i][1] = i;
        }
        
        Arrays.sort(counter, (a, b) -> (b[0] - a[0]));
        
        for(int k = 0; k < nums.length; k++){
            if(k == 0){
                result[counter[k][1]] = "Gold Medal";
            }else if(k == 1){
                result[counter[k][1]] = "Silver Medal";
            }else if(k == 2){
                result[counter[k][1]] = "Bronze Medal";
            }else{
                result[counter[k][1]] = k+1 + "";
            }
            
        }
        
        
        
        return result;
    }
}
