/********S1***********/
/**use two pointer for the sorted array
 * Arrays.copyof(arr, arr.length)
 * Arrays.sorted(arr2)
 * get the two value if found it dont forget to break the while/for loop
 * if(a == b) result[0] = i; for(int k = i+1; k++) search b starts from i+1
 * check them in the original array**/
 

    /**
     *@param nums given int array
     *@param target given target that is the sum of two numbers in the nums[]
     *@return the two indice of array
     *
     * Pre-condition: only one solution
     * conner case: nums = null
     * Map<nums[i], i>
     * check map.containsKey(target - nums[i])
     * No: add nums[i],
     * Yes: fill in the indice and break loop
     * **/
  
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if(nums == null){return result;}
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length ; i++){
            if(map.containsKey(target-nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            }else{
                map.put(nums[i], i);
            }
        }
        return result;
    }
    
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if(nums.length == 0) return result;
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsCopy);
        int left = 0, right = nums.length-1;
        while(left <= right){
            int temptarget = numsCopy[left] + numsCopy[right];
            if(temptarget == target) break;
            else if(temptarget > target) right--;
            else if(temptarget <target) left++;
        }

        int a = numsCopy[left], b = numsCopy[right];
        if(a != b) {
            for (int k = 0 ; k<nums.length; k++) {
                if(nums[k] == a) {result[0] = k;break;}
            }
            for (int j = 0 ; j<nums.length; j++) {
                if(nums[j] == b) {result[1] = j;break;}
            }
        }else{
            for (int k = 0 ; k<nums.length; k++) {
                if(nums[k] == a) {result[0] = k;break;}
            }
            for (int j = result[0]+1 ; j<nums.length; j++) {
                if(nums[j] == b) {result[1] = j;break;}
            }
        }
        return result;
        
    }
}
