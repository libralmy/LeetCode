
    /**
    * @param nums a given array that contains the money from each house
    * @return the max total that can be robbed
    * S1:
    * f(1) = num[0]
    * f(2) = Math.max(num[0], num[1])
    * f(3) = Math.max(nums[0]+num[2], num[1])
    * n from 2
    * f(n) = Math.max(f(n-1), num[n-1] + f(n-2))
    * 
    * S2:
    * only care about curr and prev
    * temp = curr
    * curr = max(prev + num[i], curr)
    * prev = temp
    **/
public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int curr = 0, prev = 0;
        for(int i = 0; i < nums.length; i++){
            int temp = curr;
            curr = Math.max(prev + nums[i], curr);
            prev = temp;
            
        }
        return curr;
    }
    /*
    public int rob(int[] nums) {

        if(nums.length == 0){
            return 0;
        }else if(nums.length == 1){
            return nums[0];
        }else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        
        int[] f = new int[nums.length +1];
        f[0] = 0;
        f[1] = nums[0];
        for(int i = 2; i <= nums.length ; i++){
            f[i] = Math.max(f[i-1], nums[i-1] + f[i-2]);
        }
        
        return f[nums.length];
    }*/
}
