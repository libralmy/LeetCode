/**
* @param S a given string that have wrong format license
* @param K a given int that should diveded given string into K group
* @output aall capital string with formated license key
* stringbuilder.length()%(K+1) == K decide whether add "-" or not
**/

public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = S.length()-1; i >= 0; i--){
            if(S.charAt(i) != '-'){
                sb.append(sb.length()%(K+1) == K? "-":"").append(S.charAt(i));
            }

        }
        
        return sb.reverse().toString().toUpperCase();
        
    }
}
