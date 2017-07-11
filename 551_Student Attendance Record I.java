/**
* @param a given String
* @return find no more than one A, or no more than two continouse L 
* check the first and last index of A are same or not(if same, it means only one A), or check contains three continouse L
**/

public class Solution {
    public boolean checkRecord(String s) {
        
        if(s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL")){
            return false;
        }
        return true;
    }
}
