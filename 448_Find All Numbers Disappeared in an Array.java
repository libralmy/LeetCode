/**
*
get (num[i]-1)%n as the index and accordingly update num[idx]
another round of iteration that get the num[i]<= n that never been visited, idx+1 is the missing number
***/


public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            nums[(nums[i]-1) % n] += n;
        }
        
        for(int j = 0; j < n; j++){
            if(nums[j] <= n){result.add(j+1);}
        }
        
        
        return result;
    }
}
