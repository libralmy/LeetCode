
    /**
    * @param nums a given integer array
    * @return list<list> sum of three integers is 0
    * 
    * conner case: if(nums == null || nums.length <= 2){return result;}
    * not get index, so sort() for using binary search
    * divide into one + two sum
    * solution set should not contain duplicate triplets
    * iterate nums[] get one 
    *       if i> 0 nums[i] == nums[i-1] continue;
    *       else call helper() to get the two sums
    * return result; 
    * void helper(result, s, e, nums,twoSum) <= sorted array could use binary search
    *       while(s < e)
    *           if nums[s] + nums[e] < twoSum  s++
    *           else if nums[s] + nums[e] >twoSum e--
    *           else ==
    *               temp.add(Arrays.asList(nums[i], nums[s], nums[e]));
    *               while(s<e && nums[s] == nums[s-1]) skip same result
    *               while(s<e && nums[e] == nums[e+1]) skip same result
    **/
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length <= 2){return result;}

        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i>0 && nums[i] == nums[i-1]){ continue;}
            twoSumhelper(result, i+1, nums.length-1, nums, -nums[i]);
        }
        
        return result;
    }
    
    public void twoSumhelper(List<List<Integer>> result, int start, int end, int[] nums, int target){
        while(start < end){
            int temp = nums[start] + nums[end];
            if(temp < target){
                start++;
            }else if(temp > target){
                end--;
            }else{
                result.add(Arrays.asList(-target, nums[start],nums[end]));
                do{start++;}while(start < end && nums[start] == nums[start-1]);
                do{end--;}while(start < end && nums[end] == nums[end+1]);
            }
        }
    }
}
