
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
    *           //prepare for the nextline
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
    **/
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        if( words == null || maxWidth < 0 || words.length ==0){return result;}
        List<String> eachline = new ArrayList<>();
        int currWordlen = 0, div = 0, mod = 0;
        String str = "";

        for(int i = 0; i < words.length ; i++){
            if(currWordlen + words[i].length() + eachline.size() <= maxWidth){
                eachline.add(words[i]);
                currWordlen += words[i].length();
            }else{
                if(eachline.size() == 1){
                    str = eachline.get(0);
                    for(int k = maxWidth - str.length(); k >0; k--){str +=" ";}
                }else if(eachline.size() > 1){
                    div = (maxWidth - currWordlen)/(eachline.size() - 1);
                    mod = (maxWidth - currWordlen)%(eachline.size() - 1);
                    str = eachline.get(0);
                    for(int j = 1; j < eachline.size() ; j++){
                        for(int k = 0; k < div; k++) str +=" ";
                        if(j <= mod){ str +=" ";}
                        str += eachline.get(j);
                    }
                }

                result.add(str);
                eachline.clear();
                eachline.add(words[i]);
                currWordlen = words[i].length();
            }
        }

        //last line
        str = eachline.get(0);
        for(int j = 1; j < eachline.size(); j++){str += " " + eachline.get(j);}
        for(int k = maxWidth - str.length(); k >0; k--){str +=" ";}
        result.add(str);

        return result;

    }
}
