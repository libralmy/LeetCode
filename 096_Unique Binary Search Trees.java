
    /**
    * @param n 
    * @return how many structurally unique BST's (binary search trees) that store values 1...n
    * O(2^n)
    * F(i, n) = G(i-1) * G(n-i)	1 <= i <= n
    * dp[i] += dp[j-1]*dp[i-j];
    * return dp[n]
    * F(3, 7): the number of unique BST tree with number 3 as its root. To construct an unique BST out of the entire sequence [1, 2, 3, 4, 5, 6, 7] with 3 as the root, which is to say, we need to construct an unique BST out of its left subsequence [1, 2] and another BST out of the right subsequence [4, 5, 6, 7], and then combine them together (i.e. cartesian product). The tricky part is that we could consider the number of unique BST out of sequence [1,2] as G(2), and the number of of unique BST out of sequence [4, 5, 6, 7] as G(4). Therefore, F(3,7) = G(2) * G(4)
    **/
  public class Solution {
    public int numTrees(int n) {

        
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i ; j++){
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
             /*
        if(n ==0 || n == 1){
            return 1;
        }else{
            int sum = 0, left = 0, right = 0;
            for(int k = 1; k <= n; k++){
                left = numTrees(k-1);
                right = numTrees(n-k);
                sum += left * right;
            }
            return sum;
        }
        // Catalan Number.
int numTrees(int n) {
    long long ans=1,i;
    for(i=1;i<=n;i++)
        ans = ans*(i+n)/i;
    return ans/i;
}
        */   
    }
}
