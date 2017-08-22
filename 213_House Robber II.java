public class Solution {
    public int rob(int[] nums) {

    /**
     * @param nums: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     * if n = 1 return nums[0]
     * 1) dont rob 0 so [1 ~ n-1]
     * 2) dont rob n-1 so [0 ~ n-2]
     */


        
        if(nums == null || nums.length == 0){return 0;}
        if(nums.length == 1){return nums[0];}
        
        int n = nums.length;
        
        int curr1 = 0, prev1 = 0;
        for(int i = 1; i < n; i++){
            int temp = curr1;
            curr1 = Math.max(prev1 + nums[i], curr1);
            prev1 = temp;
        }
        
        
        int curr2 = 0, prev2 = 0;
        for(int i = 0; i < n-1; i++){
            int temp = curr2;
            curr2 = Math.max(prev2 + nums[i], curr2);
            prev2 = temp;
        }
        
        
        return Math.max(curr1, curr2);
    }
} 
