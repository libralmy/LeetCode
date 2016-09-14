

    /**
    * @param num1 num2 two given strings
    * @return the multiply result of two number
    * set a temp array[n1.len+n2.len] 
    * mutiply every digit of n1 and n2,start from end
    * for(i1 = n1.len-1; i1--) bottom one fixed in n2 loop
    *   for(i2 = n2.len-1 i2--) top one
    *       tempM = charAt()- '0'
    *       prev digit = i1+i2, last digit = i1+i2+1
    *       M = tempM + [last]
    *       [prev] += M %10 it doesnt need to consider about overflow, will addup later
    *       [last] = M/10
    *       
    * get m[] use Stringbuilder append to string
    * start point sb.len ==0 && i = 0 will not be counted
    * 
    * return check sb.len==0?
    **/
  public class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0){return "";}
        
        int lenn1 = num1.length();
        int lenn2 = num2.length();
        int[] m = new int[lenn1 + lenn2];

        
        for(int i1 = lenn1 - 1; i1 >= 0 ; i1--){
            for(int i2 = lenn2 - 1; i2 >= 0; i2--){
                int tempM = (num1.charAt(i1) - '0') * (num2.charAt(i2) - '0');
                int prev = i1 + i2, last = i1 + i2 + 1;
                int M = tempM + m[last];
                
                m[prev] += M/10;
                m[last] = M%10;

            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i : m){
            if(i == 0 && sb.length() ==0) continue;
            sb.append(i);
        }
        return sb.length()==0? "0" : sb.toString();
    }

}
