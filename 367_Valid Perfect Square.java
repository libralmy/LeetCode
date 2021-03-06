
    /**
    * @param num a given int
    * @return the given number can be sqrt or not
    * S1
    * use binary search
    * two pointer long l, r - in case overflow
    * long mid = l +(r-l)/2
    * if(mid*mid < num) l = mid+1
    * else if mid * mid > num  r = mid -1
    * else return ture
    * S2  1+3+5+7...sqrt
    **/
public class Solution {
    public boolean isPerfectSquare(int num) {
        
        long l = 0, r = num;
        while(l <= r){
            long mid = l + (r-l)/2;
            long sq = mid * mid;
            if(sq == num){
               return true; 
            }else if(sq < num){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return false;
        
        
        
        int i = 1;
        while(num > 0){
            num -= i;
            i +=2;
        }
        return num ==0;
    }
}
