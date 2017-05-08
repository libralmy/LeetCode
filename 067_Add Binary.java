/**
* @param a, b: a given string
* @return sum of binary string
* charAt(length--) - '0' get sum and carry
**/

public class Solution {
    public String addBinary(String a, String b) {
        int sum = 0, carry = 0;
        int al = a.length()-1, bl = b.length() -1;
        StringBuilder sb = new StringBuilder();
        
        while(al >= 0 || bl >= 0){
            sum = carry;
            if(al >= 0) sum += a.charAt(al--) - '0';
            if(bl >= 0) sum += b.charAt(bl--) - '0';
            
            sb.append(sum%2);
            carry = sum/2;
        }
        
        if(carry != 0) sb.append(carry);
        
        
        return sb.reverse().toString();
        
    }
}
