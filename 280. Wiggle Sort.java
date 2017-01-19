/**
* nums[i-1] <= nums[i] >= nums[2]
* [odd] < [even]
**/ 

public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0){ return;}
        
        for(int i = 1 ; i < nums.length; i++){
            if(i%2 == 1){
                if(nums[i-1] >= nums[i]){
                    swap(nums, i);
                }
            }else if(nums[i-1] < nums[i]){
                swap(nums, i);
            }
        }
    }
    
    public void swap(int[] nums, int i){
        int temp = nums[i];
        nums[i] = nums[i-1];
        nums[i-1] = temp;
    }
}
