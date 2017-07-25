/**
* i, left, right
 if i < left < right, then result = right - left for this level of i , and while loop(left < right)
**/

public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length == 0){return 0;}
        Arrays.sort(nums);
        int n = nums.length, count = 0;
        
        for(int i = 0; i < n-2; i++){
            int left = i+1, right = n-1;
            while(left < right){
                if(nums[i] + nums[left] + nums[right]< target){
                    count += right - left;
                    left++;
                }else{
                    right--;
                }
                  
            }

        }
        
        
        return count;
    }
}
