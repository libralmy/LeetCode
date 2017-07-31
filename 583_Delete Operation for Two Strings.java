/**
*  create a matrix of (n + 1) * (m+1) where n is the length of word1 and m is the length of word2. The reason why we need to plus 1 is so we can handle some edge case like when the first character is the same.
 so the for loop all start from 1, and charAt(i-1)
find the longest common substring, return w1.len -commonlen + w2.len - commonlen
**/

public class Solution {
    public int minDistance(String word1, String word2) {
        int longest = findLongestCommonSub(word1, word2);
        
        return word1.length() - longest + word2.length() - longest;
    }
    
    public int findLongestCommonSub(String word1, String word2){
        if(word1 == null || word2 == null){ return 0;}
        int result = 0;
        int w1 = word1.length(), w2 = word2.length();
        int[][] dp = new int[w1+1][w2+1];
        
        for(int i = 1; i <= w1; i++){
            for(int j = 1; j <= w2; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                
                result = Math.max(result, dp[i][j]);
            }
        }
        
        
        
        return result;
    }
}
