
    /**
    * @param nums a given int array
    * @param target a integer that need to get the range
    * @return the range of index of target
    * 
    * sorted array, use wing <- | -> need to get mid
    * [left, right] 
    * left index:
    * if target < [mid] right = mid -1;
    * right index
    * if target > [mid] left = mid +1
    * 
    * isEnd is the identification between left and right index
    * helper(left, right, isEnd)
    **/
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if(nums == null || nums.length == 0){return result;}
        
        result[0] = findIndex(nums, 0, nums.length -1, target, false);
        result[1] = findIndex(nums, 0, nums.length - 1, target, true);
        return result;
    }
    
    public int findIndex(int[] nums, int left, int right, int target, boolean isEnd){
        int index = -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(isEnd){
                if(target >= nums[mid]){
                    if(target == nums[mid]){ index = mid;}
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else{
                if(target <= nums[mid]){
                    if(target == nums[mid]){index = mid;}
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return index;
    }
}
