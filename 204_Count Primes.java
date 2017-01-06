    /**S1:
     * 0, 1 are not prime, so conner case return
     * 2 is prime,count =1, flag = true;
     * for starts from 3, i+=2
     * inner for starts from 3, j+=2, i%j == 0 then not a prime=>break
     * according to flag, count++
     *
     *
    /**     * S2:
     * define a boolean array for get all products
     * 0, 1 are not prime, i start form 2 and smaller than n
     * All loop start from 2. check isPrime[i] is reached or not, if not get in inner loop
     * basically it is remove any 2*other, 3*other....n* other
    **/


public class Solution {
    public int countPrimes(int n) {
        if(n <=1){return 0;}
        
        boolean[] prime = new boolean[n];
        int count = 0;
        for(int i = 2; i < Math.sqrt(n); i++){
           if(!prime[i]){ 
               for(int j = 2; j*i < n ; j++){
                    prime[i*j] = true;
                }
            }
        }
        
        for(int k = 2; k < n ; k++){
            if(!prime[k]){count++;}
        }
        return count;
    }
}
/*
        if(n < 2) return 0;
        if(n == 2) return 1;

        int count = 1;
        for(int i = 3 ; i<n ; i+=2){
            boolean flag = true;
            for(int j = 3; j*j<=i ; j+=2){
                if(i%j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag)count++;
        }
        return count;
*/


    }
