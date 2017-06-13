/**
* @param s: a given string 
* @param k: a given int contains at most k distinct char
* @output the length of longest substring that has kth distinct char
* use hashmap<char, k> to maintain the size of window and record the longest path
**/

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> windowSize = new HashMap<>();
        
        int left = 0, result = 0;
        
        for(int i = 0; i < s.length(); i++){
            //save into the map
            if(!windowSize.containsKey(s.charAt(i))){
                windowSize.put(s.charAt(i),0);
            }
            windowSize.put(s.charAt(i),windowSize.get(s.charAt(i))+1);
            
            //maintian size of sliding window
            while(windowSize.size() > k){
                char leftchar = s.charAt(left);
                windowSize.put(leftchar,windowSize.get(leftchar)-1);
                
                if(windowSize.get(leftchar) == 0){
                    windowSize.remove(leftchar);
                }
                
                left++;
                
            }
            
            result = Math.max(result, i-left+1);
            
        }
        
        return result;
        
    }
}
