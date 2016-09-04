
    /**
    * @param s given string that need to be checked
    * @param t given substring that s should contain
    * @return the min window that s contains t
    * 
    * 1 use hashmap<t.char, frequency> to build a dict for t
    * 2 iterate s 
    * 3 get the basic window that contains t,
    *   and make sure the frequency(map.get(si) >= 0) is the extact number in t, for increase count
    * 3-1 when count == t.length 
    * 3-1-1 if currlen < minlen(should start at length+1, for"a", "a"), update minleft && minlen 
    * 3-1-2 if(map.contain(left))update frequency in map and the left pointer, and count--(if(map.get(lefti) > 0))
    * back to 2
    * 
    * http://articles.leetcode.com/finding-minimum-window-in-s-which/
    **/
    
public class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) return "";
        
        Map<Character, Integer> map = new HashMap<>();
        
        //iterate t and push it to dict
        for(int i = 0 ; i < t.length(); i++){
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i))+1);
            }else{
                map.put(t.charAt(i), 1);
            }
        }
        
        //iterate s
        int minleft = 0, left = 0, minlen = s.length()+1, count = 0;
        for(int i = 0 ; i < s.length(); i++){
            char si = s.charAt(i);
            //get the basic window in s
            if(map.containsKey(si)){
                map.put(si, map.get(si)-1);
                if(map.get(si) >= 0){count++;}//make sure the frequency is the extact number in t, for increase count
            }
            
            //loop in the window
            while(count == t.length()){
                //update minleft && minlen when currlen < minlen
                int currlen = i - left +1; //substring[)
                if(currlen < minlen){
                    minleft = left;
                    minlen = currlen;
                }
                
                //update frequency in map and the left pointer if needed, and count--
                char lefti = s.charAt(left);
                if(map.containsKey(lefti)){
                    map.put(lefti, map.get(lefti)+1);
                    if(map.get(lefti) > 0) {count--;}
                }
                left++;
            }
        }
        if(minlen > s.length()) return "";
        
        return s.substring(minleft, minleft+minlen);
        
    }
}
