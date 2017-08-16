public class Solution {
    /*
     * @param : An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        /**
        * continuous subsequence means increase and decrease 
        * need to go over twice
        * f[i] = max(1, f[i-1]+1(A[i-1] > A[i] && i >0)
        **/
        if(A == null  || A.length == 0){return 0;}
        int increase = 0, decrease = 0;
        int n = A.length;
        increase = getLIS(A);
        int i = 0, j = n-1;
        while(i < j){
            int temp = A[i];
            A[i++] = A[j];
            A[j--] = temp;
        }
        decrease = getLIS(A);
        
        return increase >= decrease? increase : decrease;
        
    }
    
    
    public int getLIS(int[] A){
        int result = Integer.MIN_VALUE;
        int n = A.length;
        int[] f = new int[n];
        for(int i = 0 ; i < n ; i++){
            f[i] = 1;
            if(i > 0 && A[i-1] > A[i]){
                f[i] = f[i-1] +1;
            }
            result = Math.max(result, f[i]);
        }
        

        return result;
        
    }
};
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
