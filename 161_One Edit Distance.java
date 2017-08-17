

public class Solution {
    /**
     * @param s a string
     * @param t a string
     * @return true if they are both one edit distance apart or false
     * switch s and t if s.len>t.len
     * len.diff >1 return
     * len.diff == 0, same length, only one char is differet
     * len.diff == 1, only on char is differet
     */
    public boolean isOneEditDistance(String s, String t) {
        // Write your code here
        //standard s.len >t.len
        
        if(t.length() > s.length()){
            return isOneEditDistance(t, s);
        }
        
        int diff = s.length() - t.length();
        
        if(diff > 1){
            return false;
        }
        
        if(diff == 1){
            for(int i = 0; i < t.length(); i++){
                if(s.charAt(i) != t.charAt(i)){
                    return t.substring(i).equals(s.substring(i+1));
                }
            }
        }
        if(diff == 0){
            int countdiff = 0;
            for(int i = 0; i < t.length(); i++){
                if(s.charAt(i) != t.charAt(i)){
                    countdiff++;
                }
            }
            return countdiff ==1;
        }
    
        return true;
        
    }
}
