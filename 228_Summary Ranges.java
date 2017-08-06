public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if(nums == null || nums.length == 0){return result;}
        
        for(int i = 0; i < nums.length; i++){
            int a = nums[i];
            while( i < nums.length-1 && nums[i+1] == 1 + nums[i]){
                i++;
            }
            if(a != nums[i]){
                result.add(a + "->" + nums[i]);
            }else{
                
                result.add(a + "");
            }

        }
        

        return result;
        
    }
}
