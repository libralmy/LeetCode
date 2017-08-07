/***
*
1 iteration of dict : result[i] = findAbbr()
                    build map<abbr, frequency> 
                      set up prefix[i] = 1 for the first round
2 iteration while(true): for loop result[]  
                        prefix[i]++;
                        result[i] = findAbbr(dict[i], prefix[i])
                        update map and set a flag to false
                        check flag when finish for loop at one time, if it is true, break


***/


public class Solution {
    public List<String> wordsAbbreviation(List<String> dict) {
        int n = dict.size();
        String[] result = new String[n];
        int[] prefix = new int[n];
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n ; i++){
            prefix[i] = 1;
            result[i] = findAbbr(dict.get(i), 1);
            
            if(!map.containsKey(result[i])){
                map.put(result[i],0);
            }
            map.put(result[i],map.get(result[i])+1);
        }
        
        
        while(true){
            boolean flag = true;
            
            for(int i = 0; i < n; i++){
                if(map.get(result[i]) > 1){
                    prefix[i]++;
                    result[i] = findAbbr(dict.get(i), prefix[i]);
                
            
                    if(!map.containsKey(result[i])){
                        map.put(result[i],0);
                    }
                    map.put(result[i],map.get(result[i])+1);
                    flag = false;
                }
            }
            
            
            if(flag){
                break;
            }
        }
        
        return Arrays.asList(result);
    }
    
    
    public String findAbbr(String str, int prefix){
        if(str.length()-prefix <= 2){
            return str;
        }
        return str.substring(0, prefix) + (str.length() - prefix-1) + str.charAt(str.length()-1);
        
    }
}
