/**
xyzdabc
1 xyz*1000  if d =0
2 xzy*1000 + abc + 1 if d=1
3 xyz*1000 + 1000 if d>1
***/

class Solution {
    public int countDigitOne(int n) {
        if(n <= 0){
            return 0;
        }
        
        int count = 0, p = n, k =1;
        while(p > 0){
            int digit = p % 10;
            p /= 10;
            
            count += p*k;
            
            if(digit == 1){
                count += n%k + 1;
            }
            if(digit > 1){
                count += k;
            }

            k *= 10;
        }
        
        
        return count;
    }
}
