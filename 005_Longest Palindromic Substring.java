
    /**
    * @param s a given string
    * @return a string that has longest palindrome
    * conner case if(s == null || s.length() <= 1) return s;
    * Palidrome: <-|-> 
    * Length is odd helper(s, i, i+1) verify pointer first, then chrLeft == chrRight, reverse after last step
    * Length is even helper(s, i, i)
    * temp run for both
    * refresh strlongest
    * 
    * return strlongest 
     * https://discuss.leetcode.com/topic/35582/java-easy-understanding-solution-beats-97/3
    **/
public class Solution {
    public String longestPalindrome(String s) {
        
        if(s == null || s.length() <= 1) return s;
        String strlongest = s.substring(0,1);
        
        for(int i = 0; i < s.length(); i++){
            String temp = helper(s, i, i);
            strlongest = strlongest.length() >= temp.length()? strlongest : temp;
            
            temp = helper(s, i, i+1);
            strlongest = strlongest.length() >= temp.length()? strlongest : temp;
        }
        return strlongest;
    }
    
    public String helper(String s, int toLeft, int toRight){
        while(toLeft >=0 && toRight < s.length() && s.charAt(toLeft) == s.charAt(toRight)){
            toLeft--;
            toRight++;
        }
        return s.substring(toLeft+1, toRight);
    }
}
