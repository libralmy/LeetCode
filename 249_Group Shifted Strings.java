
/**
* use str.charAt(0) 'a' to find offset and add the original as key in Map
and need to consider about if char < 'a', then add 26
***/


public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        
        
        for(String str : strings){
            int offset = str.charAt(0) -'a';
            String key = "";
            for(int i = 0 ; i< str.length(); i++){
                char temp = (char)(str.charAt(i) - offset);
                if(temp < 'a'){
                    temp += 26;
                }
                
                key += temp;
                
            }
            
            if(!map.containsKey(key)){
                
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
            
        }
        
        
        for(String key : map.keySet()){
           
            result.add(map.get(key));
        }
        
        return result;
        
    }
}
