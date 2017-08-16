

public class Solution {
    /**
     * @param num a non negative integer number
     * @return an array represent the number of 1's in their binary
     */
    public int[] countBits(int num) {
        // Write your code here
        // f[num+1], i++ i <= num
        // f[0]=0
        //f[i] = f[i>>1] + (i mod 2)
        int[] result = new int[num+1];
        result[0]=0;
        
        for(int i = 1 ; i <= num; i++){
            result[i] = result[i>>1] + i%2;
        }
        
        return result;
    }
}
