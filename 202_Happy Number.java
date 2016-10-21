
    /**
    * duplicate sum will causing the endless loop
    * use a hashset to detect it while(nonRepeatSum.add(n))
    * assign sum to n everytime finish the loop
    **/
public class Solution {
    public boolean isHappy(int n) {
        if(n == 1)return true;
        if(n == 0)return false;
        
        Set<Integer> nonRepeatSum = new HashSet<>();
        while(nonRepeatSum.add(n)){
            int sum = 0;
            int digit = 0;
            while(n > 0){
                digit = n%10;
                n = n/10;
                sum += digit*digit;
            }
            
            if(sum == 1){
                return true;
                
            }else{
                n = sum;
            }
        }
        return false;
    }
    

}
