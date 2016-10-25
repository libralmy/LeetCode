
public class Solution {
    /**
    * map<patter, str>
    * if(map.containsKey(pattern) map.get(pattern) == str? continue: return false;
    * String[] strs = str.split(" ");
    ***/
    public boolean wordPattern(String pattern, String str) {
        
        if(pattern.equals(null) || str.equals(null)){
            return false;
        }
        
        String[] strs = str.split(" ");
        if(strs.length != pattern.length()) return false; 
        
        Map<Character, String> map = new HashMap<>();
        
        for(int i = 0; i < pattern.length(); i++){
            char tempChar = pattern.charAt(i);
            String tempStr = strs[i];
            if(map.containsKey(tempChar)){
                if(!map.get(tempChar).equals(tempStr)){
                    return false;
                }
            }else{
                if(map.containsValue(tempStr)){
                    return false;
                }
                map.put(tempChar, tempStr);
            }
        }
        return true;

    }
}
