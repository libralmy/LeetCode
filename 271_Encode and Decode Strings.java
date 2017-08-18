public class Solution {
    /**
     * @param strs a list of strings
     * @return encodes a list of strings to a single string.
     * use :; to split the string in the list
     * use :: to stand for :
     */
    public String encode(List<String> strs) {
        // Write your code here
        
        String result ="";
        
        for(String str : strs){
            for(char ch : str.toCharArray()){
                if(ch == ':'){
                    result += "::";
                }else{
                    result += ch;
                }
            }
            
            result += ":;";
        }
        
        
        return result;
        
        
    }

    /**
     * @param str a string
     * @return dcodes a single string to a list of strings
     * if meet : then look for [i+1] is : then it stands for itself
     *                               is ; then it is the split signal
     * else add to the list
     */
    public List<String> decode(String str) {
        // Write your code here
        List<String> result = new ArrayList<>();
        char[] strArray = str.toCharArray();
        int i = 0;
        String temp = "";
        while(i < str.length()){
            
            if(strArray[i] == ':'){
                if(strArray[i+1] == ';'){
                    result.add(temp);
                    i += 2;
                    temp = "";
                }else if(strArray[i+1] == ':'){
                    temp += ":";
                    i += 2;
                }
            }else{
                temp += strArray[i];
                i += 1;
                
            }

        }
        
        
        return result;
        
        
    }
}


public class Codec {
    /**
    * use the length of each string and a slash as the spliter
    * get the index of spliter, s.indexOf('/', i) while i < s.length
    * get size of current string and add into list
    * i = size + spliteridx + 1
    **/
    public final char split = '/';
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length()).append(split).append(str);
        }
        return sb.toString();
        
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0){ return result;}
        //StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < s.length()){
            int splitidx = s.indexOf(split, i);
            int size = Integer.valueOf(s.substring(i, splitidx));
            result.add(s.substring(splitidx+1, splitidx+1+size));
            i = splitidx + 1 + size;
        }
        
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
