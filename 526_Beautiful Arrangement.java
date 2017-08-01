/*
A general recursive template for backtracking may look like this:

   helper (parameters of given data and current recursive level) {
        // Handle base cases, i.e. the last level of recursive call
        if (level == lastLevel) {
            record result;
            return sth;
        }
        // Otherwise permute every possible value for this level.
        for (every possible value for this level) {
            helper(parameters of given data and next recursive level);
        }
        return sth;
    }
    */
    
    
    /**
* go with backtracking. check all the possiblity 
***/

public class Solution {
    int count = 0;
    public int countArrangement(int N) {
        boolean[] used = new boolean[N+1];
        backtracking(N, used, 1);
        
        return count;
    }
    
    
    public void backtracking(int N, boolean[] used, int pos){
        if(pos > N){
            count++;
            return;
        }
        
        for(int i = 1 ; i <= N ; i++){
            if(!used[i] && (pos% i == 0 || i%pos == 0)){
                used[i] = true;
                backtracking(N, used, pos+1);
                used[i] = false;
            }
        }
        
    }
}
