/**
* @param a given unsorted array
* @return one continuous subarray that if only sort this subarray in ascending order
* compare sorted clone array with given array, end - start+1
**/
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length == 0){return 0;}
        
        int[] temp = nums.clone();
        Arrays.sort(temp);
              
        int start = 0, end = nums.length-1;
        
        while(start < nums.length && nums[start] == temp[start]){ start++;}
        
        while(end > start && nums[end] == temp[end]){end--;}
        
        
        return end-start+1;
    }
}
