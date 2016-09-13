
    /**
    * @param a given string array
    * @return longest prefix
    * conner case: strs == null || strs.length == 0
    * sort array
    * use StringBuilder.append
    * get the common part from strs[1] and strs[length -1]
    * return sb.toString()
    **/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs == null || strs.length == 0 || strs[0].length() == 0){return "";}
        StringBuilder strPrefix = new StringBuilder();
        Arrays.sort(strs);
        
        for(int i = 0 ; i < strs[0].length() ; i++){
            if(strs[0].charAt(i) == strs[strs.length - 1].charAt(i)){
                strPrefix.append(strs[0].charAt(i));
            }else{
                return strPrefix.toString();
            }
        }
        
        return strPrefix.toString();
    }
}
