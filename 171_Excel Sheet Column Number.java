public class Solution {
    /**
    * @param s a given string
    * @return int title to number
    * A = 1, B = 2..... char - 'A'+1
    * AA = sum*26 + 1, YA = (25) + (25 * 26) + 1
    * sum = sum*26 + char-'A'+1
    **/
    public int titleToNumber(String s) {
        if(s == null || s.length()==0){return 0;}
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            sum = sum*26 + temp - 'A' +1;
        }
        
        return sum;
    }
}
