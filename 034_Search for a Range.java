
    /**
    * @param nums an int array
    * @param target an int that will be showing up in the nums
    * @return an array that contains the start and end indice of target
    * 
    * it is looking for two indices for the target new int result[2]
    * 
    * fintIndice() -> two pointer start and end <- | -> Binary Search ~O(logn)
    * leftbound: isLast = false
    *            nums[mid] <= target if= idx = mid
    * rightboudn: isLast = true
    *            nums[mid] >=target if= idx = mid
    * result[0] = findIndice(nums, target , isLast) 
    * result[1] = findIndice(nums, target , isLast);
    **/
public class Solution {    
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];

        result[0] = findIndice(nums, target, false);
        result[1] = findIndice(nums, target, true);
        
        return result;

    }
    
    public int findIndice(int[] nums, int target, boolean isLast){
        int idx = -1;
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(isLast){
                if(nums[mid] <= target){
                    if(nums[mid] == target) idx = mid;
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }else{
                if(nums[mid] >= target){
                    if(nums[mid] == target) idx = mid;
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }

        }
        return idx;
    }

}
