/**
*
use list as storage
for() add up fizz and buzz for each loop, 
when fizz reach to 3, reset to 0
when buzz reach to 5, reset to 0
else res.add(String.valueOf(i));

**/
class Solution {
    public List<String> fizzBuzz(int n) {
        
        List<String> res = new ArrayList<>();
        int fizz = 0, buzz = 0;
        
        for(int i = 1; i <= n; i++){
            fizz++;
            buzz++;
            
            if(fizz == 3 && buzz == 5){
                res.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            }else if(fizz == 3){
                res.add("Fizz");
                fizz = 0;
            }else if(buzz == 5){
                res.add("Buzz");
                buzz = 0;
            }else{
                res.add(String.valueOf(i));
            }
        }
        
        
        return res;
    }
}
