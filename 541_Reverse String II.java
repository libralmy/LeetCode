public class Solution {
    public String addStrings(String num1, String num2) {
        if(num1 == null || num2 == null){return num1;}
        
        StringBuilder sb = new StringBuilder();
        int sum = 0, carry = 0;
        int i = num1.length()-1, j = num2.length()-1;
        
        while( i>= 0 || j>= 0 || carry > 0){
            int d1 = i < 0 ? 0 : num1.charAt(i--)-'0';
            int d2 = j < 0 ? 0 : num2.charAt(j--)-'0';
            sum = d1+d2+carry;
            carry = sum / 10;
            sb.append((sum%10));
            
            
        }
        
        return sb.reverse().toString();
    }
}
