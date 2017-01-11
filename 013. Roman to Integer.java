/**
* MDCLXVI
* convtoInt[s.length()] 
* if c[i] < c[i+1] sum-= else sum+=
* return sum+c[s.length()-1]
**/

public class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length()== 0){return 0;}
        
        int[] ctoint = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++){
            switch(s.charAt(i)){
                case 'M':
                    ctoint[i] = 1000;
                    break;
                case 'D':
                    ctoint[i] = 500;
                    break;
                case 'C':
                    ctoint[i] = 100;
                    break;
                case 'L':
                    ctoint[i] = 50;
                    break;
                case 'X':
                    ctoint[i] = 10;
                    break;
                case 'V':
                    ctoint[i] = 5;
                    break;
                case 'I':
                    ctoint[i] = 1;
                    break;
            }
        }
        int sum = 0;
        for(int i = 0; i < s.length()-1; i++){
            if(ctoint[i] < ctoint[i+1]){
                sum -= ctoint[i];
                
            }else{
                sum += ctoint[i];
            }
        }
        
        return sum + ctoint[s.length()-1];
    }
}
