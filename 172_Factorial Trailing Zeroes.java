/**
trailing zero ~ 2*5 
if int ends with zero, it means it greater than 5! 
so n>= 5, as long as it has 2, it means it will ends with 0
so need to calculate how many 5 n has

**/

class Solution {
    public int trailingZeroes(int n) {
        
        int res = 0;
        while(n >= 5){
            n /= 5;
            res += n;
        }
        
        return res;
    }
}
