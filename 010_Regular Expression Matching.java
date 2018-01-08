/**
DP
initiate si =null & pj ='*' & f[0][j-1] : f[0][j] = true
if pj == si || pj =='.': f[i][j] = f[i-1][j-1]
if pj =='*'
    1 pj-1 != si && pj-1 !='.' : f[i][j] = f[i][j-2] //*a stands for empty
    2 pj-1 == si || pj-1 =='.' :
      f[i][j] =    f[i][j-1]        //*a stands for one single a
                    || f[i][j-2]    //*a stands for empty
                    || f[i-1][j]    //*a stands for multiple a
**/
class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null){return false;}
        
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        
        for(int j = 0; j < p.length(); j++){
            if(p.charAt(j) =='*' && dp[0][j-1]){
                dp[0][j+1] = true;
            }
        }
        
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < p.length(); j++){
                if(p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'){
                    dp[i+1][j+1] = dp[i][j];
                }
               
                
                if(p.charAt(j) == '*'){
                    if(p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.'){
                        dp[i+1][j+1] = dp[i+1][j-1];
                    }else{
                        dp[i+1][j+1] = dp[i+1][j] || dp[i+1][j-1] || dp[i][j+1];
                    }
                }
                
            }
        }
   
        
        return dp[s.length()][p.length()];
    }
    

}
