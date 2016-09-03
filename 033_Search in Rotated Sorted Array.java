
    /**
    * @param nums an given sorted and rotated array
    * @param target find the index of this target
    * @return the index of the target, if dont find it, return -1
    * 
    * while(left<=right)
    * make sure the rotated point is at left or right
    * if [mid] >= [left] looking into left side
    *   start <= target < [mid]] right = mid -1
    *                           
    * else looking into right side
    *   [mid] < target <= [right] left = mid + 1
    **/
public class Solution {
    public int search(int[] nums, int target) {
        int index = -1, left = 0, right = nums.length -1;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                index = mid;
            }
            
            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && nums[mid] > target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(target <= nums[right] && nums[mid] < target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            
        }
        return index;

    }
}
