public class Solution {
    /*
     * @param nums: An array of integers
     * @return: An integer
     solution: if a[i] > 0, f[i] = Math.max(f[i-1]*a[i], a[i])
                            f[i] = Math.max(g[i-1]*a[i], a[i])
     if a[i] < 0, g[i] = Math.min(g[i-1]*a[i], a[i])
                    g[i] = Math.min(f[i-1]*a[i], a[i])
    then iterate f[i] to get the max
     */
    public int maxProduct(int[] nums) {
        // write your code here

        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = nums[0];
        g[0] = nums[0];
        

        for(int i = 1; i < n; i++){
            f[i] = nums[i];
            f[i] = Math.max(f[i-1] * nums[i], f[i]);
            f[i] = Math.max(g[i-1] * nums[i], f[i]);
            
            g[i] = nums[i];
            g[i] = Math.min(g[i-1] * nums[i], g[i]);
            g[i] = Math.min(f[i-1] * nums[i], g[i]);
        }
        
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            result = Math.max(f[i], result);
        }
        
        return result;
    }
}
    /**
     * @param nums given int array
     * @return max product of this array
     *
     * conner case: array is null;
     * when two negative numbers product, the result might be greater than current max
     * so it needs to keep a temp = max, and use temp*nums[i] as a predict min number
     * Math.min(nums[i], Math.min(temp*nums[i], min*nums[i]));
     * **/
public class Solution {
    public static int maxProduct(int[] nums) {
        if(nums == null){return 0;}

        int max = nums[0];
        int min = nums[0];
        int maxProd = nums[0];

        for(int i = 1; i < nums.length; i++){
            int temp = max;
            max = Math.max(nums[i], Math.max(max*nums[i], min*nums[i]));
            min = Math.min(nums[i], Math.min(temp*nums[i], min*nums[i]));
            if(maxProd < max){
                maxProd = max;
            }
        }
        return maxProd;
    }
}
