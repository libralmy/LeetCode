/**
 * s.split(" ") => array
 * backward track the string array
 * Notice: to avoid the duplicated space, it has to check arr[i].isEmpty()
 * StringBuilder to append " ", String[]
 * trim the result;
 **/
 
public class Solution {
    public String reverseWords(String s) {
        
        String[] strArr = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = strArr.length -1; i>=0 ; i--){
            if(!strArr[i].isEmpty()){
                sb.append(" ");
                sb.append(strArr[i]);
                
            }
        }
        
        return sb.toString().trim();
        /*
        String[] word = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i<word.length ; i++){
            if(!word[i].isEmpty()){
                sb.insert(0, " ");
                sb.insert(0, word[i]);

            }
        }

        return sb.toString().trim();
        */
        
    }
}
