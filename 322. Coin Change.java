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
