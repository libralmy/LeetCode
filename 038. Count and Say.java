/**
* outer for 1->n
* for(int j = 1,count = 1; j <= s.length() ; j++){
                if(j == s.length() || s.charAt(j) != s.charAt(j-1)){
**/

public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        
        for(int i = 1; i < n ;i ++){
            StringBuilder sb = new StringBuilder();
            for(int j = 1,count = 1; j <= s.length() ; j++){
                if(j == s.length() || s.charAt(j) != s.charAt(j-1)){
                    sb.append(count).append(s.charAt(j-1));
                    count = 1;
                }else{
                    count++;
                }
            }
            s = sb.toString();
        }
        
        return s;
    }
}
