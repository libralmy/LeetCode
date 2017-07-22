/**
*
@param a given string
@param a given integer 

     * 0            k           2k          3k
     * |-----------|-----------|-----------|---
     * +--reverse--+           +--reverse--+
     
solution get last boundary min(i+k-1, s.length()-1)
[0, k] reverse, [k, k+k] remain, so i += 2*k
[0, k) reverse all - will be the last corner case
**/

public class Solution {
    public String reverseStr(String s, int k) {
        char[] sarry = s.toCharArray();
        
        int i = 0, n = sarry.length;
        
        while(i < n){
            int min = Math.min(i+k-1, n-1);
            swap(sarry, i, min);     
            i += 2*k;
        }
        
        
        return String.valueOf(sarry);
    }
    
    public void swap(char[] sarry, int i, int min){
        while(i < min){
            char temp = sarry[i];
            sarry[i++] = sarry[min];
            sarry[min--]= temp;
        }
    }
}
