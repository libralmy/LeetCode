/**
* @param: a given string
* @return: a list of all possible flip
* i start from 1 and combine (0,i-1) with "--" and (i+1, length)
**/

public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        
        if(s == null || s.length() == 0){return result;}
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '+' && s.charAt(i-1) == '+'){
                result.add(s.substring(0,i-1) + "--" + s.substring(i+1, s.length()));
            }
        }
        
        return result;
    }
}
