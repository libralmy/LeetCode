
    /**
    * @param a given int array
    * @return the first missing positive int
    * 
    * value should be equal to the index 0= num[0], 1=num[1]
    * first iteration is to swap(i,nums[i])
    * nums[i]>=0 && nums[i]<n && nums[nums[i]] != nums[i] swap()
    * else i++
    * index start at 1,{1}
    * second iteration is to find the index<n & index = num[index] index++
    * if index <n return index
    * else nums[0] == index? index+1: index;
    * 
    **/

    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0){return 1;}
        
        for (int i = 0; i < nums.length; i++) {
            while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]){
                swap(nums, nums[i]-1,i);
            }
        }
        
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j+1){
                return j+1;
            }
        }
        
        return nums.length+1;
    }
    
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

  public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        int i = 0, n = nums.length;

        while(i < n){
            if(nums[i] >= 0 && nums[i] < n && nums[nums[i]] != nums[i]){
                swap(nums, i, nums[i]);
            }else{
                i++;
            }
        }
        
        int index = 0;
        while(index < n && nums[index] == index){
            index++;
        }
        
        if(index < n){
            return index;
        }else{
            return nums[0] == index? index+1: index;
        }
    }
    
    public void swap(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
