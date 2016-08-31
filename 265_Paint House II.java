
    /**
     * @param costs a n*k int array
     * @return min cost of painting house with no same color in two adjacent houses
     * conner case: array is null
     * 
     * Level1: n house need to be painted
     * Level2: k colors could selected
     * Level3: find the smallest cost in k colors
     * if we want reach the time complexity O(nk), we have to optimize our operation at level 3
     * index- min1: smallest cost of previous house  initial(-1)inloop and outloop for return
     * index- min2: 2nd smallest cost of previous house  initial(-1)inloop and outloop
     * 
     * temp index - last1: keep smallest cost of previous house
     * temp index - last2: keep the 2nd smallest cost of previous house
     * start level2: check ki == last1? cant select same color in two adjacence house
     *              last1, last2 <0 is the start point
     * optimize level3: min1<0 || current cost is smaller than min color, 
     *                  updateoriginal min1 as min2, min1 as current color
     *                  compare with min2 as well and consider update min2
     * return costs[n-1][min1]
    **/
    
public class Solution {
    public int minCostII(int[][] costs) {
        if(costs.length == 0 || costs[0].length == 0)
            return 0;
        int n = costs.length, k = costs[0].length;
        int min1 = -1, min2 = -1;
        
        for(int ni = 0; ni < n; ni++){
            int last1 = min1, last2 = min2;
            min1 = -1; 
            min2 = -1;
            
            for(int ki = 0; ki < k; ki++){
                if(ki != last1){
                    costs[ni][ki] += last1 < 0? 0 : costs[ni-1][last1];
                }else{
                    costs[ni][ki] += last2 < 0? 0 : costs[ni-1][last2];
                }
                
                if(min1 < 0 || costs[ni][ki] < costs[ni][min1]){
                    min2 = min1; min1 = ki;
                }else if(min2 < 0 || costs[ni][ki] < costs[ni][min2]){
                    min2 = ki;
                }
            }
        }
        
        return costs[n-1][min1];

        
    }
}
