
    /**
    * first 2
    * same color: s(1) = k
    * diff color: d(1) = k*(k-1)
    * dp[0] = k, dp[1]=s(1) + d(1) = k*k +k
    * first 3
    * s,s,d : s(2) = (k-1)*k
    * d,d,d : d(2) = (k-1)*k*k
    * dp[2] = (k-1) * (dp[0]+dp[1])
    ***/
   public class Solution {
    public int numWays(int n, int k) {
        if(n== 0 || k==0){
            return 0;
        }
        int[] dp = new int[]{k, k*k, 0};
        
        if(n <= 2){
            return dp[n-1];
        }
        
        for(int i = 3; i <= n; i++){
            dp[2] = (k-1) * (dp[0] + dp[1]);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }
}
