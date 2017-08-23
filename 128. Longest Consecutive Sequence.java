
    /**
    *S1
    * use hashset to maintain the num in the nums
    * input all num to hashset
    * another forloop to nums
    * num[i] decrease-- check it is in hashset, if it is in, remove it and count++
    * num[i] increase++ check it is in hashset, if it is in, remove it and count++
    * max = math.max(count, max)
    * S2(remove action start from the smalleset one)
    * check decrease-- is in set or not,if it in, continue
    * else it means find the smallest one, then remove all the elem which is greater than it
    * max record val - num(if non consecutive int, then max will 1)
    **/

    public class Solution {
    /*
     * @param num: A list of integers
     * @return: An integer
     use set to get all numbers
     iterate num[] and use if(!set.contains(num-1)) get the smallest num
     use while(set.remove(val)) val++
     return (max, val-num)
     */
    public int longestConsecutive(int[] num) {
        // write your code here
        int max = 0;
        Set<Integer> map = new HashSet<>();
        
        for(int n : num){
            if(!map.contains(n)){
                map.add(n);
            }
        }
        
        for(int n : num){
            
            //get the samllest
            if(!map.contains(n-1)){
                int temp = n;
                while(map.remove(temp)){
                    temp++;
                }
                
                max = Math.max(max, temp-n);
            }
        }

        return max;
    }
};
    public int longestConsecutive(int[] nums) {
        /*
        if(nums == null || nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            if(!set.contains(num))set.add(num);
        }
        int max = 0;
        for(int i = 0; i < nums.length ; i++){
            int n = nums[i], count = 1;
            while(set.contains(--n)){
                count++;
                set.remove(n);
            }
            n = nums[i];
            while(set.contains(++n)){
                count++;
                set.remove(n);
            }
            
            max = Math.max(count, max);
        }
        return max;
        */
      Set<Integer> set = new HashSet<>();
      int max = 0;
      for(int num : nums) set.add(num);
      for(int num : nums) {
          if (!set.contains(num-1)) {
            int val = num;
            while(set.remove(val)) val++;
            max = Math.max(max, val-num);
        }
      }
      return max;

    }

