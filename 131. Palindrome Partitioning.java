public class Solution {
    public List<List<String>> partition(String s) {
          List<List<String>> result = new ArrayList<>();
          
          if(s == null || s.length() == 0){return result;}
          
          backtrack(result, new ArrayList<>(), s, 0);
          
          return result;
    }
    
    public void backtrack(List<List<String>> result, List<String> tempList, String s, int start){
        if(tempList.size() > 0 && start >= s.length()){
            result.add(new ArrayList<>(tempList));
        }
        for(int i = start ; i < s.length(); i++){
            if(isPalidorme(s, start, i)){
                if(start == i){
                    tempList.add(String.valueOf(s.charAt(start)));
                }else{
                    tempList.add(s.substring(start, i+1));
                }
                backtrack(result, tempList, s, i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }
    
    
    public boolean isPalidorme(String s, int start, int end){
        if(start ==  end){return true;}
        while(start < end && start >= 0 && end < s.length()){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }else{
                start++;
                end--;
            }
        }
        
        return true;
    }
    
}
