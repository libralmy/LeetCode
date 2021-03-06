
    /**
     * @param s: a input string
     * @return : int that represent length of non repeat substring
     * S1: fast and slow pointer
     * DS: int[] -> 256 digit of ASIIC
     *      slow pointer response for the repeat char, if char exsited, then reset lettermap that slow pointed, slow++
     *      fast pointer update int[] lettermap as 1 means it is exsited, and Max of count = fast-slow+1
     * S2: fast and slow pointer
    * conner case: s ==null || s.length()==0
    * Set<char[]> 
    * two pointers slow(record the left bound) and fast(record the right bound)
    *               |-> ......|
    * when fast < s.length()
    *   if set contains char
    *       remove the charAt(slow), and move slow pointer to right till it doesnt contain the repeat one
    *   else set add char
    *       refresh the max length Math.max((fast-slow+1), max);
    * 
    * return max
     * **/
public class Solution {    
   public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256]; // map from character's ASCII to its last occured index
        
        int count = 0;
        for (int slow = 0,fast = 0; fast < s.length(); fast++) {
            int charAtfast = s.charAt(fast);
            while (map[charAtfast]!=0 && slow < fast) {
                int charAtslow = s.charAt(slow);
                map[charAtslow] = 0;
                slow++;
            }
            map[charAtfast] = 1;
            count = Math.max(count, fast-slow + 1);
        }
        
        return count;
    }
   
   public int lengthOfLongestSubstring(String s) {
       int count = 0;
       Set<Character> set = new HashSet<>();
       int slow = 0, fast = 0;
       while(fast < s.length()){
           if(set.contains(s.charAt(fast))){
               set.remove(s.charAt(slow));
               slow++;
           }else{
               set.add(s.charAt(fast));
               count = Math.max(count, set.size());
               fast++;
           }
       }
       
       return count;
       
   }
    

}
