/**
0: 1
1: [1,9] 9(base)
2: [1,9] [0,9] 9*9(base) + 9 + 1
3: [1,9] [0,9] [0,9] 9*9*8(base) + 9 + 1 
...
base = 9
base = base * (9-i+2)
***/


public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0){return 1;}
        int result = 10;
        if(n == 1) return result;
        
        int base = 9;
        for(int i = 2; i <= n; i++){
            base = base * (9-i+2) ;
            result += base;
        }
        
        return result;
    }
}
