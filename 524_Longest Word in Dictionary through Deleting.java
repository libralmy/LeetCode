/**
*
iterate dictionary and then string
replace longest string when longest.length() < word.length() ---for updating the first null one
word.compareTo(longest) < 0 -- for return the longest word with the smallest lexicographical order

***/


public class Solution {
    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        
        for(String word : d){
            int i = 0;
            for(char c : s.toCharArray()){
                if(i < word.length() && c == word.charAt(i)){
                    i++;
                }
            }
            
            if(i == word.length() && longest.length() <= word.length()){
                if(longest.length() < word.length() || word.compareTo(longest) < 0) longest = word;
            }
            
        }
        
        
        return longest;
    }
}
