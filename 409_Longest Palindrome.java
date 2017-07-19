/**
* @param a given string
* @return the longest possible of palindorme combanation
* blooean map[128] if met once, set true: map[char] = !map[char]
* if(!map[char]) met twice will be false, then len+2
* final judge len < lenght(), it means could get extra as the middle one
**/


public class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0){return 0;}
        int len = 0;
        
        boolean[] map = new boolean[128];
        
        for(char c : s.toCharArray()){
            map[c] = !map[c]; //met once set as true
            if(!map[c]) len += 2;
        }
        
        if(len < s.length()) len++;
        
        return len;
    }
}
