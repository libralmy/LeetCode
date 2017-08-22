  public class Solution {
    /*
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null || prices.length == 0){return 0;}
        
        int profit = 0, min = Integer.MAX_VALUE;
        int n = prices.length;
        
        for(int i = 0; i < n; i++){
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i]- min);
           
            
        }
        
        return profit;
    }
}
  
  
  
  /**iterate in order
     * bought keep the smallest num=> 
     * bought < prices[i]
     *      if profit < prices[] - bought => update profit
     * bought >= prices[i] => update bought*/
    public static int maxProfit(int[] prices) {
        /*
        int maxCurr = 0, maxSofar = 0;
        for(int i = 1; i<prices.length ; i++){
            maxCurr += prices[i]-prices[i-1];
            maxCurr = Math.max(0,maxCurr);
            maxSofar = Math.max(maxCurr, maxSofar);
        }
        return maxSofar;
        */
        if(prices.length == 0) return 0;
        int bought = prices[0];
        int profit = 0;

        for(int i = 1 ; i< prices.length ; i++){
            if(bought < prices[i]){
                if(profit < prices[i] - bought){
                    profit = prices[i] - bought;
                }
            }else{
                bought = prices[i];
            }
        }

        return  profit;
    }
