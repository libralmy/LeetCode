public class Solution {
    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // Write your code here
        // i= 1 i++ stands for house
        // j stands for current house color
        // k < 3 k!= j k stands for color in previous house

        // f[i][0] = min(f[i-1][1]+cost[i-1][0], f[i-1][2]+ cost[i-1][0])
        // f[i][j] = min(f[i][j], f[i-1][k] + cost[i-1][j])
        int n = costs.length;
        int[][] f = new int[n+1][3];
        
        f[0][1] = f[0][0] = f[0][2] = 0;
        
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < 3; j++){
                f[i][j] = Integer.MAX_VALUE;
                
                for(int k = 0; k < 3; k++){
                    if(k != j){
                        f[i][j] = Math.min(f[i][j], f[i-1][k] + costs[i-1][j]);
                    }
                }
            }
        }
       
        return Math.min(f[n][0], Math.min(f[n][1], f[n][2]));
    }
}   


/**
     * @param costs a 3*3 int array
     * @return min cost of painting house with no same color in two adjacent houses;
     * cost[hourse#][color] 0-red, 1-blue, 2-green
     * costofR = 0, costofG = 0, costofB = 0
     * Ri : f[i] + Math.min(costofG, costofB)
     * costofR = Ri
     * 
     * return Math.min(R, G, B)
     *
     * **/
    public int minCost(int[][] costs) {
        int costofR = 0, costofB = 0, costofG = 0;
        for(int i = 0; i< costs.length; i++){
            int Ri = costs[i][0] + Math.min(costofB, costofG);
            int Bi = costs[i][1] + Math.min(costofR, costofG);
            int Gi = costs[i][2] + Math.min(costofR, costofB);

            costofR = Ri;
            costofB = Bi;
            costofG = Gi;
        }
        return Math.min(costofR, Math.min(costofB, costofG));

    }
