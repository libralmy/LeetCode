public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int counter = 0, max = 0; 
        
        for(int n : nums){
            if(n == 0){
                counter = 0;
            }else if( n == 1){
                counter++;
            }
            
            max = Math.max(max, counter);
            
        }
        
        return max;
    }
}
