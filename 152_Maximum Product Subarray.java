
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
