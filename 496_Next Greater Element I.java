/***
* use stack to control the decreasing array
use map to collect<smaller, greater>
***/

public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        //iterate nums
        for(int num : nums){
            
            while(!stack.isEmpty() && stack.peek() < num){
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        
        //iterate findNums and update it
        for(int i = 0; i < findNums.length ; i++){
            if(map.containsKey(findNums[i])){
                findNums[i] = map.get(findNums[i]);
            }else{
                findNums[i] = -1;
            }
        }
        
        
        return findNums;
        
    }
}
