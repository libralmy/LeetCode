
    /**
    * @param a given string 
    * @return convert string to integer
    * conner case: flag of negative; isDigit; overflow;
    * trim();
/**
* sign and start point
* long sum, in number range, or out of Integer bound
**/

public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0){return 0;}
        //sign
        int sign = 1, start = 0;
        
        char[]digit = str.trim().toCharArray();
        
        if(digit[0] == '+'){
            sign = 1;
            start = 1;
        }else if(digit[0] == '-'){
            sign = -1;
            start = 1;
        }
        
        long sum = 0;
        
        for(int i = start; i < digit.length ; i++){
            
            if(digit[i] >= '0' && digit[i] <= '9'){
                sum = sum*10 + Character.getNumericValue(digit[i]);
            }else{
                return (int)sum*sign;
            }
            
            if(sum >= Integer.MAX_VALUE && sign == 1){
                return Integer.MAX_VALUE;
            }else if(sign == -1 && sum * sign <= Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
                
            }
        }
        
        return (int)sum*sign;
    }
}
