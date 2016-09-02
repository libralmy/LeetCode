
    /**
    *@param words given string array
    *@param word1 
    *@param word2
    *@return the shortest distance between word1 and word2
    * S1
    * set up a flag that mark word1 == word2
    * two pointer p1 for word1, p2 for word2
    * if(iterate == word1) flag == same? p1 = p2, p2 = i: p1 = i
    * else p2 =i
    * when p1 != -1 && p2 != -1 get min
    * 
    * S2
    * if word1 != word2 => use p1 = -1 and p2 =-1 method
    * else it turns to get shortest distance between the two same words
    *      so just need to remmeber current i and previous pi
    *      when pi assigned a new value ,get min(i - pi, distance)
    *      other than that, pi =i
    **/
public class Solution {    
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if(words.length == 0){return 0;}
        int p1= -1, p2 = -1, distance = Integer.MAX_VALUE;
        if(!word1.equals(word2)){
            for(int i = 0; i < words.length; i++){
                if(words[i].equals(word1)){
                    p1 = i;
                    if(p2 != -1){distance = Math.min(distance, Math.abs(p1-p2));}
                }else if(words[i].equals(word2)){
                    p2 = i;
                    if(p1 != -1){distance = Math.min(distance, Math.abs(p1-p2));}
                }
            }
        
        }else{
            
            for(int i = 0; i < words.length; i++){
                if(words[i].equals(word1)){
                    if(p1 != -1){
                        distance = Math.min(distance, (i-p1));
                    }
                    p1 = i;
                }
            }
            
        }

        return distance;
    }
    /*
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if(words.length == 0){return 0;}
        int p1= -1, p2= -1, distance = Integer.MAX_VALUE;
        boolean flagsame = word1.equals(word2)? true: false;
        
        for(int i = 0; i < words.length ; i++){
            if(words[i].equals(word1)){
                if(flagsame){
                    p1 = p2;
                    p2 = i;
                }else{
                    p1 = i;
                }
            }else if(words[i].equals(word2)){
                p2 = i;

            }
            
            if(p1 != -1 && p2 != -1){
                distance = Math.min(distance, Math.abs(p1-p2));
            }
        }
        
        return distance;
    }*/
}
