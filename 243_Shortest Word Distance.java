
    /**
     * @param words given string array as dict
     * @param word1 given string as start point
     * @param word2 given string as end point
     * @return distance between start and end
     * 
     * 
     * w1 != w2 is the precondition, 
     * S1:
     * setup two pointer p1 =-1 and p2=-1, updated to index when found it
     * distance = Integer.MAX_VALUE;
     * words[i].equals(word1);
     * 
     * 
     * S2: 
     * check p2 in words[i].equals(word1) and update distance
     * check p1 in words[i].equals(word1) and update distance
     * **/
public class Solution {
    public static int shortestDistance(String[] words, String word1, String word2) {
        if(words == null){return 0;}
        int p1 = -1, p2 = -1;
        int distance = Integer.MAX_VALUE;
        
        for(int i = 0; i<words.length; i++){
            if(words[i].equals(word1)){
                p1 = i;
                if(p2 != -1) distance = Math.min(distance, Math.abs(p1-p2));
                
            }else if(words[i].equals(word2)){
                p2 = i;
                if(p1 != -1) distance = Math.min(distance, Math.abs(p1-p2));
            }
        }
        return distance;
    }
}
