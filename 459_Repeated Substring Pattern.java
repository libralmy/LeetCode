public class Solution {
    /**
    * i = strLength/2, if(strLength % i == 0), divisor = i, 
    * temp.equals(str.substring(divisor, divisor+i)), divisor == strLength
    **/
    public boolean repeatedSubstringPattern(String str) {
        if(str == null){
            return false;
        }
        int l = str.length();
        
        for(int i = l/2; i >0; i--){
            if(l % i == 0){
                String temp = str.substring(0, i);
                int divisor = i;
                while(divisor < l){
                    if(temp.equals(str.substring(divisor, divisor+i))){
                        divisor += i;
                    }else{
                        break;
                    }
                    
                }
                
                if(divisor == l){return true;}
            }
        }
        
        return false;
    }
}
