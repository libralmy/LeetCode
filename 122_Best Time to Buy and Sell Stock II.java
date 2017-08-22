public class Solution {
    /*
     * @param prices: Given an integer array
     * @return: Maximum profit
     you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again)
     */
    public int maxProfit(int[] prices) {
        // write your code here
        
        if(prices == null || prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int profit = 0;
        for(int i = 1; i < n; i++){
            if(prices[i-1] <= prices[i]){
                profit += prices[i] - prices[i-1];
            }
        }
        
        return profit;
    }
}
