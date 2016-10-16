
/**
* noZ present the index of non zero digit
* noZ++ when num!=0
* and then fill in 0 for rest of num
**/
public class Solution {
    public static void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){return;}
        int noZ = 0;
        for(int num: nums){
            if(num != 0){
                nums[noZ++] = num; 
            }
        }
        
        while(noZ < nums.length){
            nums[noZ++] = 0;
        }

    }
    
    
}
