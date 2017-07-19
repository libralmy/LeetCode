/**
* @param a given string word 
* @param a given string abbr num+char = word.length()
* @return word could be the abbrevition of abbr 
* num in the abbr + char in the abbr should be the length of word (idxchar+num) == word.length()
* reset num when meet char
**/


public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if(word == null || abbr == null){return false;}
        
        int num = 0;
        int idxchar = 0;
        
        for(char c : abbr.toCharArray()){
            if(c == '0' && num == 0){return false;}
            
            if(c <= '9' && c >= '0'){
                num = num*10 + (c-'0');
            }else{
                idxchar += num;
                if(idxchar >= word.length() || c != word.charAt(idxchar)){ return false;}
                num = 0;//reset num when meet char
                idxchar++;
            }
        }
        
        return (idxchar+num) == word.length();
    }
}
