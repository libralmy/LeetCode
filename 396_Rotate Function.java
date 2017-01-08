/**
* f0 = [0]*0 + [1]*1 + [2]*2 + [3]*3
* f1 =         [0]*1 + [1]*2 + [2]*3 + [3]*0
* f2 =                 [0]*2 + [1]*3 + [2]*0 + [3]*1
* f0+ sum = [0]1 [1]2 [2]3 [3]4
* fi = fi-1 + sum - n*[n-i]
* fi=>  for i=1 i <= n
**/

public class Solution {
    public int maxRotateFunction(int[] A) {
        if(A == null || A.length == 0){return 0;}
        int f0 = 0, sum = 0;
        int n = A.length;
        for(int i = 0; i < n; i++){
            f0 += i*A[i];
            sum += A[i];
        }
        
        int max = f0, fi = f0;
        
        for(int i = 1; i <= n ; i++){
            fi = fi + sum - n*A[n-i];
            if(fi > max){max = fi;}
        }
        
        return max;
        
    }

}
