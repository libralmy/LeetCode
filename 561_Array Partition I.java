/**
sorted array to get ascend order 
make sure min is the max value that it could get
**/

class Solution {
    public int arrayPairSum(int[] nums) {
        if(nums == null || nums.length == 0){return 0;}
        
        Arrays.sort(nums);
        int res = 0;
        int i = 0;
        while(i < nums.length){
            res += nums[i];
            i+=2;
        }
        
        return res;
        
    }
}
