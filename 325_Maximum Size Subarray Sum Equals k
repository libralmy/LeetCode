/**
* @param nums: an given array
* @param k: a given sum
* @return : Maximum Size Subarray Sum Equals k
* 1) [0-i] : sum+=nums[i], put all the sum in the map that before i 
* 2) (i-j] : 
*    0_____i
*    0__________j   
*    k = sum[j] - sum[i] compare Max( (j-i), max)
**/

public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int counter = 0, sum =0;
        if(nums == null || nums.length ==0){return counter;}
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            
            sum += nums[i];
            
            if(sum == k){
                counter = i+1;
            }else if(map.containsKey(sum - k)){
                counter = Math.max(counter, i - map.get(sum-k));
            }
            
            if(!map.containsKey(sum)){map.put(sum, i);} //eg. 3 + 1 + -1
        }
        
        return counter;
        
    }
}
