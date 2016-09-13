
    /**
    * @param a given string 
    * @return convert string to integer
    * conner case: flag of negative; isDigit; overflow;
    * trim();
    * record the first elem is negative sign or not
    * iterate str.char() from start
    *   if(!Character.isDigit(temp)) return return (int)sum * sign;
    *   char - '0' 
    *   sum*10 + char - '0'
    *   greater than MAX, smaller than MIN
    **/
public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0){return 0;}
        str = str.trim();
        long sum = 0; 
        int start = 0, sign = 1;
        if(str.charAt(0) == '+'){
            sign = 1;
            start = 1;
        }else if(str.charAt(0) == '-'){
            sign = -1;
            start = 1;
        }
        
        for(int i = start ; i < str.length(); i++){
            char temp = str.charAt(i);
            if(!Character.isDigit(temp)){
                return (int)sum * sign;
            }
            sum = sum*10 + (temp-'0');
            
            if(sign == 1 && sum >= Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else if(sign == -1 && sum * sign <= Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return (int)sum * sign;
    }
}
