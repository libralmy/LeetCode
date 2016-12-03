/**
*swap() from 0 to s.length()-1 => reverse whole senetence
*for() if meet space, then reverse the word(start, i-1), then sart = i+1
*for() will stop at last space, so it wont reach the last word, swap(start, lenght-1)=> swap the last word and avoid the conner case**/
public class Solution {
    public void reverseWords(char[] s) {
        if(s == null || s.length == 0){return;}
        
        swap(s, 0, s.length-1);
        
        int slow = 0;
        for(int fast = 0; fast < s.length; fast++){
            if(s[fast] == ' '){
                swap(s, slow, fast-1);
                slow = fast+1;
            }
        }
        swap(s, slow, s.length-1);
    }
    
    public void swap(char[] s, int left, int right){
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

}
