public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() ==0 || p == null || p.length() == 0 || p.length() > s.length()){return result;}
        
        int fast = 0, slow = 0;
        int[] map = new int[26];
        for(int i = 0 ; i < p.length() ; i++){
            map[p.charAt(i) - 'a']++;
        }
        
        int count = p.length();
        while(fast < s.length()){
            if(map[s.charAt(fast)- 'a'] > 0){
                count--;
            }
            
            map[s.charAt(fast)- 'a']--;    
            fast++;
            
            
            if(count == 0){
                result.add(slow);
            }
            
        //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
        //++ to reset the hash because we kicked out the left
        //only increase the count if the character is in p
        //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if(fast - slow == p.length()){
                if(map[s.charAt(slow)- 'a'] >= 0){
                    count++;
                }
                map[s.charAt(slow)- 'a']++;
                slow++;
            }
            
            
        }
        
        return result;
    }
}
