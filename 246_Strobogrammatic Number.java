public class Solution {
     /**
     * @param num a string
     * @return true if a number is strobogrammatic or false
     * map[num.charAt(i)] == num.charAt(s.length()-i-1)
     */
    public boolean isStrobogrammatic(String num) {
        // Write your code here

        int[] map = new int[256];
        
        map['0'] = '0';
        map['1'] = '1';
        map['8'] = '8';
        map['6'] = '9';
        map['9'] = '6';
        
        for(int i = 0; i < num.length(); i++){
            int end = num.length() - 1 - i;
            if(map[num.charAt(i)] != num.charAt(end)){
                return false;
            }
        }
        
        return true;
    }
    
    
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
