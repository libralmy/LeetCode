/***
DP: f[0] =1
count one digit: f[n] = f[n-1] condition: s[n-1] != '0'
count two digits: f[n] = f[n-2] + f[n-1] condition: 10<= s[n-2]s[n-1] <= 26 


****/
public class Solution {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // Write your code here
        if(s.length() == 0) return 0;
        
        
        int len = s.length();
        int[] f = new int[len + 1];
        f[0] = 1;
        char[] sc = s.toCharArray();
        
        for(int i = 1 ; i <= len; i++){
            if(sc[i-1] != '0'){
                f[i] += f[i-1];
            }
            
            if(i >= 2){
                int val = (sc[i-2]-'0') * 10 + (sc[i-1]-'0');
                if(val >= 10 && val <= 26){
                    f[i] += f[i-2];
                }
            }
        }
        
        
        return f[len];
    }
}
