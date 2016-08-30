/**
* @param x: input double 
* @param n: pow is n
* @return x^n
* 
* use binary search to get the result
* conner case: n<0,      n = 0, x = 1, x= 0
*              n=-n,1/x, x=1,   1      0
* mypowhelper() return case will be n == 0, 
* binary search n%2 != 0, then need to product extra x
* just return mypowhelper(x*x, n/2)
* 
**/

public class Solution {
    public double myPow(double x, int n) {
        if(n == 0 || x == 1){
            return 1;
        }else if( x == 0){
            return 0;
        }else if(n < 0){
            n = -n;
            return mypowhelper(1/x, n);
        }else{
            return mypowhelper(x, n);
        }
        
    }
    
    public double mypowhelper(double x, int n){
        if(n == 0) return 1;
        
        if(n%2 == 0) return mypowhelper(x*x, n/2);
        else return x * mypowhelper(x*x, n/2);
    }
}
