/**
* @param: a given string
* @return: capital legal
* only 1 char, compare whole lowercase, capital , skip first using substring(1)
***/


public class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length() <2 ) return true;
        if(word.toLowerCase().equals(word) || word.toUpperCase().equals(word)) return true;
        if(word.substring(1).toLowerCase().equals(word.substring(1))) return true;
        
        return false;
    }
}
