/**
* @param two given string, one with extra random letter
* @return the different char
* use the last char of longer string as the standard charcode, add and remove all, then the one left (char) int is the one
**/

public class Solution {
    public char findTheDifference(String s, String t) {
        int charcode = (int)t.charAt(t.length()-1);
        
        for(int i = 0; i < s.length(); i++){
            charcode -= (int)s.charAt(i);
            charcode += (int)t.charAt(i);
        }
        
        return (char)charcode;
    }
}
