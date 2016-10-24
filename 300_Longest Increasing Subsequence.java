
public class Solution {
    /**
    * use a temp array to store the increasing value for nums
    * if it is increase, then assign nums to it
    * else use binary search to get the lowest postion and assign new nums[i]
    * increasing[0] = nums[0];
    * so length start from 1
    **/
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] increasing = new int[n];
        increasing[0] = nums[0];
        int length = 1;
        
        for(int i = 1; i < n; i++){
            if(nums[i] > increasing[length-1]){
                increasing[length] = nums[i];
                length++;
            }else{
                int position = binarySearch(increasing, 0, length-1, nums[i]);
                increasing[position] = nums[i];
            }
        }
        return length;
    }
    
    public int binarySearch(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                high = mid -1;
            }else{
                low = mid +1;
            }
        }
        
        return low;
        
    }
}
