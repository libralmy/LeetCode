// If there is more than one string belong to the same key
// then the key will be invalid, we set the value to ""
public class ValidWordAbbr {
    Map<String, String> map;
    
    
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        
        for(String str : dictionary){
            String key = getKey(str); 
            
            
            if(map.containsKey(key)){
                

                if(!map.get(key).equals(str)){
                    map.put(key, "");
                }
            }else{
                
                map.put(key, str);
                
            }
        }
    }
    
    public boolean isUnique(String word) {
        return !map.containsKey(getKey(word)) || map.get(getKey(word)).equals(word);
    }
    
    
    public String getKey(String word){
        if(word.length() <=2){
            return word;
        }
        
        return word.charAt(0)+ Integer.toString(word.length()-2) + word.charAt(word.length()-1);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
