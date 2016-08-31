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
