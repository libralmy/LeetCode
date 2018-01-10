
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i+=2){
            if(i+1 < nums.length && nums[i] == nums[i+1]){
                continue;
            }else{
                res = nums[i];
                break;
            }
        }
        
        return res;
        
    }
}
