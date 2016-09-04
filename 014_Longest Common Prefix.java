
    /**
    * @param strs a given string array 
    * @return the longest common prefix of this string array
    * 
    * sorted str array
    * compare the common part between first and last elem
    **/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){return "";}
        Arrays.sort(strs);
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < strs[0].length() ; i++){
            if(strs[0].charAt(i) == strs[strs.length -1].charAt(i)){
                s.append(strs[0].charAt(i));
            }else{
                return s.toString();
            }
        }
        
        return s.toString();
    }

}
