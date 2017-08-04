/**
* use boolean[] array to record the range of word as true
use i and end= max(end, i+word.len) 
iterate string -> iterate dict -> check the s.startsWith(word, i)
boolean[] = end>i

**/

public class Solution {
    public String addBoldTag(String s, String[] dict) {
        boolean[] wordRange = new boolean[s.length()];
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            for(String word: dict){
                if(s.startsWith(word, i)){
                    end = Math.max(end, i+word.length());
                }
            }
            wordRange[i] = end > i;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!wordRange[i]){
                sb.append(s.charAt(i));
                continue;
            }
            
            int j = i;
            while(j < s.length() && wordRange[j]){j++;}
            sb.append("<b>").append(s.substring(i,j)).append("</b>");
            i = j-1;
        }
        
        
        return sb.toString();
        
        
    }
}
