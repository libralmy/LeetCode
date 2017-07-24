public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double res = 0.00;
        
        if(nums == null && nums.length == 0){
            return res;
        }
        int sum = 0;
        for(int i = 0; i < k ; i++){
            sum += nums[i];
        }
        
        int max = sum;
        for(int i = 0, j = k; j < nums.length; i++, j++) {
            sum = sum - nums[i] + nums[j];
            max = Math.max(max, sum);
        }
        
        
        return (double)max / (double)k;
    }
}
