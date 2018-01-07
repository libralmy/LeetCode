/**
S1:
make sure major elem appears > n/2 
initial major = nums[0], count =1
start from i=1
if count=0: major=num[i],count++
else if major = num[i]: count++
else count--
S2:
map<nums[i], frequency>
**/

class Solution {
    
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length ==0){return 0;}
        
        int count = 1, major = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(count == 0){
                count++;
                major = nums[i];
                
            }else if(major == nums[i]){
                count++;
            }else{
                count--;
            }
        }
        
        return major;
    }
    /*
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length ==0){return 0;}
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int major = nums[0];
        
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
                if(map.get(nums[i]) > n/2){
                    major = nums[i];
                    break;
                }
            }else{
                map.put(nums[i], 1);
            }
        }
        
        return major;
    }*/
}
