/**
S1: //Recursive
if(b==0) return a
carry is the one that a and b are same in bitwise, so need to carry on for next roung and shift to left one digit
carry = a&b <<1
sum = a^b
sum will be the a, carry will be the b

S2:  //Iterative
while b!=0
carry = a&b
a = a^b
b = carry<<1
**/
class Solution {
    //Recursive
    /*
    public int getSum(int a, int b) {
        if(b == 0){
            return a;
        }
        int sum, carry;
        sum = a ^b;
        carry = (a&b) << 1;
        
        return getSum(sum, carry);
    }
    */
    
    //Iterative
    public int getSum(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;
        
        while(b != 0){
            
            int carry = a&b;
            a = a^b;
            b = carry << 1;
        }
        
        return a;
        
    }
}
