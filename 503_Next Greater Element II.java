/**
*
circular array for(i < nums.length*2)
Arrays.fill(-1)
use stack to record the index of decreasing array
if(i < n) stack.push(i);
***/

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        Arrays.fill(result, -1);
        
        for(int i = 0; i < n*2 ; i++){
            int num = nums[i%n];
            while(!stack.isEmpty() && nums[stack.peek()] < num){
                result[stack.pop()] = num;
            }
            
            if(i < n) stack.push(i);
        }
        
        return result;
    }
}
