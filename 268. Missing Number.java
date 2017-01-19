public class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null){return 0;}
        
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        
        return (nums.length * (nums.length+1) /2) - sum;
    }
}
