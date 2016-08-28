    /**S1
     * convert s to string arry according to space s.split("\\s+"); \s stands for tab, space, extra line... + means more than one
     * then use stringbuilder to append string arry bottom up
     * if string builder is not null, dont forget append " "
     * clean the result, trim() the space of last word
     **/
    /**S2
     * s replace all extra spaces, s = s.replaceAll("\\s+"," ");
     * then check if s only has one space return "" => dont forget to trim the result for " 1"
     * convert string to char[]
     * reverse whole sentence 
     * reverse each word when meet ' ' and save i to start+1 point
     * last word wont have ' ', so it needs to be cleaned isolated
     **/
public class Solution {

    public static String reverseWords(String s) {
        if(s.length() == 0){ return "";}
        String[] strArry = s.split("\\s+");
        StringBuilder strB = new StringBuilder();
        for(int i = strArry.length - 1; i >= 0; i--){
            if(strB.length() != 0){
                strB.append(" ");
            }
            strB.append(strArry[i]);
        }
        return strB.toString().trim();

        
    }
    
    
    /**
     * s replace all extra spaces, s = s.replaceAll("\\s+"," ");
     * then check if s only has one space return "" => dont forget to trim the result for " 1"
     * convert string to char[]
     * reverse whole sentence 
     * reverse each word when meet ' ' and save i to start+1 point
     * last word wont have ' ', so it needs to be cleaned isolated
     **/
    
    public static String reverseWords(String s) {
        if(s.length() ==0){return "";}//return if it is null
        s = s.replaceAll("\\s+", " ");
        if(s.equals(" ")){return "";}
        
        
        char[] rev = s.toCharArray();
        //reverse whole sentence
        reverse(rev, 0, rev.length-1);

        //reverse each word
        int start = 0;
        for(int i = 0; i < rev.length ; i++){
            if(rev[i] == ' '){
                reverse(rev, start, i-1);
                start = i+1;//' ' +1 should be the start
            }
        }
        //last word wont have space, so it needs to clean isolated
        reverse(rev, start, rev.length-1);

        return String.valueOf(rev).trim();

    }


    public static void reverse(char[] rev, int start, int end){
        while(start < end){
            char temp = rev[start];
            rev[start++] = rev[end];
            rev[end--] = temp;
        }
    }
    
    
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
