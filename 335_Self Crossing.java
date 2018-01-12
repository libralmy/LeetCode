/***
There are only 3 scenarios where it won’t cross itself.

The distances of the moves parallel to each other keeps going up (growing spiral). 
a2 < a4 
The distances of the moves parallel to each other keeps going down (shrinking spiral).
The distances of the moves parallel to each other first keeps going up, then keeps going down (shrinking spiral inside of the growing spiral), and never goes up.
x.length < 4 return false
**/

class Solution {
    public boolean isSelfCrossing(int[] x) {
        int a1, a2, a3, a4, a5;
        
        if(x.length < 4){
            return false;
        }
        a1 = 0;
        a2 = x[0];
        a3 = x[1];
        a4 = x[2];
        
        boolean increase = false;
        
        if(a2 < a4){
            increase = true;
        }else{
            increase = false;
        }
        
        for(int i = 3; i < x.length ; i++){
            a5 = x[i];
            if(!increase && a5 >= a3){
                return true;
            }else if(increase && a5 <= a3){
                if((a1 + a5) < a3 || ( (i+1) < x.length && (x[i+1]+a2) < a4)){
                    increase = false;
                }else if((i+1) < x.length){
                    return true;
                }
                
            }
                                  
            a1 = a2;
            a2 = a3;
            a3 = a4;
            a4 = a5;
            
        }
        return false;
    }
    
   
}
