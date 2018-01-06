
/***
S1:
count how many ones in bitwise
a^b remove the same digit and leave the differences
for(i =>32) count += x>>i  & 1

S2: more efficient
Integer.bitCount(x^y);
**/

class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        int xor = x ^ y;
        for(int i = 0; i < 32; i++){
            count += (xor>>i) & 1;
        }
        return count;
        /*
        return Integer.bitCount(x^y);
        */
    }
}
