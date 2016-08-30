public class Solution {

    /**
     * @param nums a given int array
     * @return the max sum in array
     * 
     * set sum is 0, max will be the smallest int
     * if sum is smaller than 0, there is no meaning to addup nums[i]
     * so sum will start at nums[i]
     * compare sum and max
     * **/
    public static int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int sum = 0, max = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            if(sum > 0){
                sum += nums[i];
            }else{
                sum = nums[i];
            }
            
            if(sum > max){
                max = sum;
            }
        }
        return max;
    }

}
