
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        
        //if(A == null || B == null || A.length == 0|| B.legth == 0){return new int[][];}
        int rA = A.length, cA = A[0].length, cB = B[0].length;
        int[][] C = new int[rA][cB];
        
        for(int ra = 0; ra < rA; ra++){
            for(int ca = 0; ca < cA; ca++){
                if(A[ra][ca] != 0){
                    for(int cb = 0; cb < cB; cb++){
                        if(B[ca][cb] != 0){
                            C[ra][cb] += A[ra][ca] * B[ca][cb];
                            
                        }
                    }
                }
            }
        }
        
        return C;
    }
}
