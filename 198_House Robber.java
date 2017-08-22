
    /*
     * @param A: An array of non-negative integers
     * @return: The maximum amount of money you can rob tonight
                no-rob,  rob  
     f[i] = max{f[i-1], f[i-2] + A[i-1]}
     f[0] = 0; f[1] = A[0]; 
     */
    public long houseRobber(int[] A) {
        // write your code here
        if(A == null || A.length == 0){ return 0;}
        
        
        int n = A.length;
        long[] f = new long[n+1];
        f[0] = 0;
        f[1] = A[0];
        
        for(int i = 2; i <= n; i++){
            f[i] = Math.max(f[i-1], f[i-2]+A[i-1]);
        }
        
        return f[n];
        
    } 


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
   
}
