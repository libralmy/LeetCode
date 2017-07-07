public class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0){return s;}
        
        Set<Character> libary = new HashSet<>();
        libary.add('a');
        libary.add('e');
        libary.add('i');
        libary.add('o');
        libary.add('u');
        libary.add('A');
        libary.add('E');
        libary.add('I');
        libary.add('O');
        libary.add('U');
        
        char[] schar = s.toCharArray();
        int l = 0, r = s.length()-1;
        while(l<r){
            if(libary.contains(schar[l]) && libary.contains(schar[r])){
                char temp = schar[l];
                schar[l] = schar[r];
                schar[r]= temp;
                l++;
                r--;
            }else if(!libary.contains(schar[l]) && libary.contains(schar[r])){
                l++;
            }else if(libary.contains(schar[l]) && !libary.contains(schar[r])){
                r--;
            }else{
                l++;
                r--;
            }
        }
        
        return String.valueOf(schar);
    }
}
