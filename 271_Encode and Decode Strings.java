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
