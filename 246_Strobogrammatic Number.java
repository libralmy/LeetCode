public class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0){return false;}
        
        Map<Character, Character> libary = new HashMap<>();
        libary.put('0','0');
        libary.put('1','1');
        libary.put('8','8');
        libary.put('6','9');
        libary.put('9','6');
        int l = 0, r = num.length()-1;
        while(l <= r){
            
            if(!libary.containsKey(num.charAt(l))){return false;}
            if(libary.get(num.charAt(l)) != num.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
