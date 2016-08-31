
    /**
     * @param str an input string
     * @return a int that converted by string
     *
     * conner case: str == null
     * long sum
     * condition: 7
     *            space :trim() before do anything
     *            contains non-number: Charactor.isDigit()
     *            normal: sum = sum*10 + charAt -'0'
     *            positive sign: keep sign from first char as 1
     *            negative sign: keep sign from first char as -1
     *            >MAX_VALUE: return max
     *            <MIN_VALUE: return min
     * return (int)sum*sign
     *
     *
     * ***/
public class Solution {
    public static int myAtoi(String str) {
        if(str.length() == 0){return 0;}
        long sum = 0;
        int sign = 1;
        int start = 0;
        str = str.trim();
        
        if(str.charAt(0) == '+'){
            start++;
        }else if(str.charAt(0) == '-'){
            sign = -1;
            start++;
        }

        for(int i = start; i < str.length(); i++){
            char temp = str.charAt(i);
            
            if(!Character.isDigit(temp)){
                return (int) sum*sign;
            }
                
            sum = sum*10 + (temp - '0');
            
            if(sign == 1 && sum > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else if(sign == -1 && (sign * sum) < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }

        return (int) sum*sign;

    }
}
