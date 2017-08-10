public class Solution {
    /**
     * @param coins  a list of integer
     * @param amount a total amount of money amount
     * @return the fewest number of coins that you need to make up
     * solution: 
     * 1) state: f[amount+1]
     * 2) transformal state equation: f[X] = Math.min(f[X-1]+1, f[X-2]+1, f[X-5]+1)
     * if(i >= coins[j] && f[i - coins[j]] != Integer.MAX_VALUE){
                    f[i] = Math.min(f[i - coins[j]] +1, f[i]); 
                }
     * 3) initial & conner case: f[0]=0
     * 4) order of calculation: from 1
     */
    public int coinChange(int[] coins , int amount) {
        // Write your code here
        
        int[] f = new int[amount+1];
        f[0] = 0;
        
        for(int i = 1; i <= amount; i++){
            f[i] = Integer.MAX_VALUE;
            
            for(int j = 0; j < coins.length; j++){
                
                if(i >= coins[j] && f[i - coins[j]] != Integer.MAX_VALUE){
                    f[i] = Math.min(f[i - coins[j]] +1, f[i]); 
                }
                
            }
            
            if(f[amount] == Integer.MAX_VALUE){
                f[amount] = -1;
            }
            
        }
        
        
        return f[amount];
        
    }
}











public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount <= 0 || coins == null || coins.length == 0){return 0;}
        int[] amtNum = new int[amount+1];
        
        for(int amt = 1; amt <= amount; amt++){
            amtNum[amt] = Integer.MAX_VALUE;
            for(int i = 0; i < coins.length; i++){
                if(amt >= coins[i] && amtNum[amt-coins[i]] != Integer.MAX_VALUE){
                    amtNum[amt] = Math.min(amtNum[amt], 1+ amtNum[amt - coins[i]]);
                }
            }
        }
        
        if(amtNum[amount] == Integer.MAX_VALUE){
            return -1;
        }else{
            return amtNum[amount];
        }
    }
}
