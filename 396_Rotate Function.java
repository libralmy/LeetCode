/**
* f0 = [0]*0 + [1]*1 + [2]*2 + [3]*3
* f1 = [0]*1 + [1]*2 + [2]*3 + [3]*0
* f0+ sum = [0]1 [1]2 [2]3 [3]4
* f1 = f0 + sum - n*[n-1]
**/

public class Solution {
    public int maxRotateFunction(int[] A) {
        if(A == null || A.length == 0){return 0;}
        int f0 = 0, sum = 0;
        for(int i = 0; i < A.length; i++){
            f0 += A[i]*i;
            sum += A[i];
        }
        
        int max = f0, fi = f0;
        for(int i = 1; i < A.length; i++){
            fi += sum;
            fi -= A.length*A[A.length-i];
            
            max = Math.max(fi, max);
            
        }
        
        return max;
        
    }

}
