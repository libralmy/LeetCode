/**
* @param s: a given string that contains parentheses
* @return List<String>: all possible result that remove the minimum number of invalid parenthese
* BFS
* Set<String> maintain a non-repeat storage of all valid result
* Queue<String> maintain all possible result that need to be valided
* 
**/
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        
        if(s == null){ return result;}
        
        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        
        q.add(s);
        set.add(s);
        boolean flag = false;
        while(!q.isEmpty()){
            String temp = q.poll();
            
            if(isValid(temp)){
                result.add(temp);
                flag = true;
                
            }
            if(flag){continue;}//stay in the same level, minimum number of invalid parenthese
            
            for(int i = 0; i < temp.length(); i++){
                if(temp.charAt(i) != '(' && temp.charAt(i) != ')') continue;
                
                String tempStr = temp.substring(0,i) + temp.substring(i+1);
                
                if(!set.contains(tempStr)){
                    q.add(tempStr);
                    set.add(tempStr);
                }
            }
            
        }
        
        return result;
    }
    
    
    
    public boolean isValid(String s){
        int counter = 0;
        for(int i = 0; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                counter++;
            }
            
            //["()())("]
            if(s.charAt(i) == ')'){
                if(counter == 0)return false;
                counter--;
            }
        }
        
        return counter ==0;
    }
}
