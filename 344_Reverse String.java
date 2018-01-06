class Solution {
    public String reverseString(String s) {
        if(s.isEmpty() || s.length() ==0){
            return s;
        }
        
        char[] temp = s.toCharArray();
        int i = 0, j = s.length()-1;
        while(i<j){
            char t = temp[i];
            temp[i] = temp[j];
            temp[j] = t;
            i++;
            j--;
        }
        
        return new String(temp);
    }
}
