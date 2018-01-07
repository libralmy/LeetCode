
//count 1 in bitwise
//for i-> 32, count += n>>i & 1 
//Integer.bitCounter();
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++){
            count += (n >>i) & 1;
        }
        
        return count;
    }
}
