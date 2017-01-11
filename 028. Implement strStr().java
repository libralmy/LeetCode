/**
* no-bound inner and outer loop
* inner length j == needle.len return outer i index
* i+j == haystack.len return -1
* ha.[i+j] != ne[j] break
**/

public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null){return 0;}
        
        for(int i = 0;;i++){
            for(int j = 0;; j++){
                
                if(j == needle.length()) return i;
                if(i+j == haystack.length()){return -1;}
                if(haystack.charAt(i+j) != needle.charAt(j)){break;}
            }
        }
    }
}
