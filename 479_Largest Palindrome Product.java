/***
if n=1 return 9
up = math.pow(10,n) -1, low = up/10
max = up*up
firsthalf = max/math.pow(10,n)
while(!found) 
    palid = createPalid(firsthalf)
    for i=up, i>low, i--
        if padlid/i> up || i*i<palid break
        if palid%i ==0 return palid
    firsthalf--


***/

class Solution {

    
    


    private long createPalindrom(long num) {
        String str = num + new StringBuilder().append(num).reverse().toString();
        return Long.parseLong(str);
    }
        public int largestPalindrome(int n) {
        if(n ==1 ){return 9;}
        
        int up = (int)Math.pow(10,n) - 1;
        int low = up/10;
        long max = (long)up* (long)up;
        
        int firsthalf = (int)(max/(long)Math.pow(10,n));
        long palindrome = 0;
        boolean found = false;
        
        while(!found){
            palindrome = createPalind(firsthalf);
            
            for(long i = up; up > low; i--){
                if(palindrome/i > up || i*i < palindrome){
                    break;
                }
                
                
                if(palindrome % i == 0){
                    found = true;
                    break;
                    
                }
            }
            firsthalf--;
        }
        
        
        
        return (int)(palindrome % 1337);
    }
    
    public long createPalind(long firsthalf){
        String palindr = firsthalf + new StringBuilder().append(firsthalf).reverse().toString();
        return  Long.parseLong(palindr);
    }
}
