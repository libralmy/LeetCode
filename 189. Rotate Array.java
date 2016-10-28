public class Solution {
    /**
    1 2 3 4 5 6 7
    7 6 5 4 3 2 1
    5 6 7 1 2 3 4
    k%=nums.length
    
    ***/
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0){return;}
        k %= nums.length;
        swapNode(nums, 0, nums.length-1);
        swapNode(nums, 0, k-1);
        swapNode(nums, k, nums.length-1);

    }
    
    public void swapNode(int[] nums, int low, int high){
        while(low < high){
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }
}
