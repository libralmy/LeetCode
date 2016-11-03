
public class Solution {
/**
* String[] smallthanTen, smallerthanTwenty, smallerthanHundred
* helper() sb.append  helper(num/100) + " Thousand " + helper(num%100);
**/
    public final String[] smallthanTen = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    public final String[] smallthanTwenty = new String[]{"Ten","Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public final String[] smallthanHundred = new String[]{"","Ten","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    
    public String numberToWords(int num) {
        if(num == 0){return "Zero";}
        
        return helper(num);
    }
    
    public String helper(int num){
        StringBuilder sb = new StringBuilder(); 
        if(num < 10){
            sb.append(smallthanTen[num]).append(" "); 
        }else if(num < 20){
            sb.append(smallthanTwenty[num%10]).append(" "); 
        }else if(num < 100){
            sb.append(smallthanHundred[num/10]).append(" ").append(helper(num%10));
        }else if(num < 1000){
            sb.append(helper(num/100)).append(" Hundred ").append(helper(num%100));
        }else if(num < 1000000){
            sb.append(helper(num/1000)).append(" Thousand ").append(helper(num%1000));
        }else if(num < 1000000000){
            sb.append(helper(num/1000000)).append(" Million ").append(helper(num%1000000));
        }else{
            sb.append(helper(num/1000000000)).append(" Billion ").append(helper(num%1000000000));
        }
        
        return sb.toString().trim();
    }
}
