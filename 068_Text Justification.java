
    /**
    * @param words given string array that contains the text need to be adujusted
    * @param each line has exactly maxWidth characters
    * @return list of string that fully justify 
    * 
    * currWordlen, space, 
    * @eachline<list string>, 
    * @eachline.size() # of words in this line; stands for the min # of space that need to in this line
    * @currWordlen stands for the length of words in this line
    * for(str: words)
    *   add words in the each line till it is been filled up currWordlen + word[i].length + eachline.size() <= maxWidth
    *   after filled up
    *       one word in a line
    *           @str line.get(0) + fill up the rest of space 
    *       more than one word in a line
    *           @div count how many space that need to put between each word(rest of avliable space/ #-1)
    *               (maxWidth - currWordlen)/(eachline.size() - 1);
    *           @mod cound how many extra space that need to put in first mod# words
    *           @str line.get(0)
    *               merge spaces and word line.get(j) j start from 1
    *                   //deal with spaces
    *                   put div of space between to word
    *                   if(j<=mod) put extra space in between
    *                   
    *           result.add(line)
    *           line.clear()
    *           //prepare for the nextline, cause it is not been added in the last if
    *           line.add(word[i])
    *           currWordlen = word[i].length
    * 
    * //out loop, deal with the last line
    * @str line.get(0) j start from 1
    * put a space between to word + word
    * fill up the rest of space
    * result.add(line)                 
    *                   
    * return result
    * // add rest of spacefor(int k = maxWidth-inLine.length(); k > 0; k--){inLine +=" ";}
    **/
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        if(words == null || words.length == 0 || maxWidth < 0){return result;}
        
        int dev = 0, mod = 0, currLength = 0;
        List<String> temp = new ArrayList<>();
        String inLine = "";
        
        for(int i = 0; i < words.length ; i++){
            if(temp.size() + words[i].length()+ currLength <= maxWidth){
                temp.add(words[i]);
                currLength += words[i].length();
            }else{
                if(temp.size() == 1){
                    inLine = temp.get(0);
                    for(int k = maxWidth-inLine.length(); k > 0; k--){
                        inLine +=" ";
                    }
                }else if(temp.size() > 1){
                    //int spaceCount = temp.size()-1;
                    dev = (maxWidth - currLength) / (temp.size()-1);
                    mod = (maxWidth - currLength) % (temp.size()-1);
                    inLine = temp.get(0);
                    for(int j = 1; j < temp.size(); j++){
                        for(int d = 0; d < dev; d++){inLine +=" ";}
                        if(j <= mod) {inLine+=" ";}
                        inLine += temp.get(j);
                    }
                }
                result.add(inLine);
                temp.clear();
                temp.add(words[i]); //cause it is not been added in the last if
                currLength = words[i].length();//cause it is not been added in the last if
            }
        }
        
        inLine = temp.get(0);
        for(int j = 1; j < temp.size(); j++){inLine += " "+ temp.get(j);}
        for(int k = maxWidth-inLine.length(); k >0 ; k--){
                inLine +=" ";
         }
        result.add(inLine);
        return result; 
    }
}
