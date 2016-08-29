
    /**
     * @param s: input string 
     * @return longest palindorm string
     * conner case if(s.length() <= 1) return s;
     * <-|-> wing solution
     * iterate all the elem in string
     * use extra function to decide it is Palindorme or not, and recover the left and right pointer from last while
     * verify the length of string is odd or even
     * https://discuss.leetcode.com/topic/35582/java-easy-understanding-solution-beats-97/3
    **/
public class Solution {
    public static String longestPalindrome(String s) {
        if(s.length() <= 1) return s;
        String longestStr = s.substring(0,1);
        
        for(int i = 0; i < s.length() ; i++){
            
            String temp = isPalindorme(s, i, i);//odd
            longestStr = longestStr.length() >= temp.length()? longestStr : temp;
            
            temp = isPalindorme(s, i, i+1);//even
            longestStr = longestStr.length() >= temp.length()? longestStr : temp;
        }
        
        return longestStr;
    }
    
    static String isPalindorme(String s, int toleft, int toright){
        
        while(toleft >= 0 && toright < s.length() && s.charAt(toleft) == s.charAt(toright)){
            toleft--;
            toright++;
        }
        return s.substring(toleft+1, toright);
    }
}
