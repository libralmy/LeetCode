/**
* @param a given list of string
* @return validWordSquare
* from upper left to bottom right, align elem should be same 
**/


public class Solution {
    public boolean validWordSquare(List<String> words) {
        if(words.isEmpty()){return false;}
        
        int lev = words.size();
        
        for(int r = 0; r < lev; r++){
            for(int c = 0; c < words.get(r).length(); c++){
                if(c >= lev|| words.get(c).length() <= r ||words.get(r).charAt(c) != words.get(c).charAt(r)){
                    return false;
                }
            }
        }
        
        
        return true;
    }
}
