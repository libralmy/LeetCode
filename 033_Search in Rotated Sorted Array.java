
    /**
    * @param nums a given int array
    * @param target a integer
    * @return the index of target
    * if(nums[mid] < nums[start]){//right bound   if add = [3,1] will throw err
    * 
    * if(nums[mid] < target && nums[end] >= target) [start]= [end]=*
    
    * while(left <= right) length == 1
    * mid = left +(right - left)/2 
    * [mid] == target return mid
    * [left] >[mid] fall in left bound <-
    *    [left] <= target <[mid] right = mid-1
    * else fall in right bound ->
    *    [mid]< target <=[right] left = mid+1
    **/
public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }
            //right bound
            if(nums[mid] < nums[left]){
                if(nums[mid] < target && nums[right] >= target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else{//left bound
                if(nums[left] <= target && nums[mid] > target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        
        return -1;
    }
}
