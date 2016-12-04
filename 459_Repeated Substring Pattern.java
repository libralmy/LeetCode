public class Solution {
    /**
    * for getting the repeat substring, that means it can be devided into same length
    * so the cursor start from halfway and without remain at least, decreaseing 
    * ---|------ 
    * for| while->checking the rest of string has same repeat pattern or not
    **/
    public boolean repeatedSubstringPattern(String str) {
        if(str == null){
            return false;
        }
        int strLength = str.length();
        for(int i = strLength/2; i > 0; i--){
            if(strLength % i == 0){
                String tempstr = str.substring(0, i);
                int divisor = i;
                while(divisor < strLength){
                    if(str.substring(divisor, divisor+i).equals(tempstr)){
                       divisor += i; 
                    }else{
                        break;
                    }
                }
                
                if(divisor == strLength){return true;}
            }
        }
        
        return false;
    }
}
