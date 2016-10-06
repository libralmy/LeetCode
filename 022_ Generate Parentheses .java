
/**
* @param n input pairs of parenthesis
* @return a list combanation of n pairs of parenthesis
* 
* backtracking
* make sure leftpair > rightpair, unless it cant add more )
* and leftpair < n, unless it cant add more (
**/
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n <= 0){return result;}
        
        generathelper(result,"", 0, 0, n);
        return result;
    }
    
    public void generathelper(List<String> result, String str, int left, int right, int max){
        if(str.length() == max*2){
            result.add(str);
            return;
        }
        
        if(left < max){
            generathelper(result, str+"(", left+1, right, max);
        }
        
        if(right < left){
            generathelper(result, str+")", left, right+1, max);
        }
    }
}
