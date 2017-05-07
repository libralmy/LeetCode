/**
* @parm nums: an array 
* @void return: in place exchange
* set a index for zero, if not zero, then move zero index to right
* if array has zero, the iteration of nums[i] will reach end before zero index, so it needs to fill up rest of array
* 
***/
public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){return;}
        
        int zeroIdx = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[zeroIdx] = nums[i];
                zeroIdx++;
            }
        }
        
        while(zeroIdx < nums.length){
            nums[zeroIdx++] = 0;
        }
        
    }
}
