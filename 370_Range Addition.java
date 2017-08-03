/**
Put inc at startIndex allows the inc to be carried to the next index starting from startIndex when we do the sum accumulation.
Put -inc at endIndex + 1 simply means cancel out the previous carry from the next index of the endIndex, because the previous carry should not be counted beyond endIndex.
***/

public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        
        for(int[] update: updates){
            int start = update[0];
            int end = update[1];
            int val = update[2];
            
            result[start] += val;
            if(end < length-1) result[end+1] -= val;
        }
        
        
        for(int i = 1 ; i < length; i++){
            result[i] += result[i-1];
        }
        
        return result;
    }
}
