/**
* use two arraylist to maintaine the char and counter, a pointer to track where they get
*
***/


public class StringIterator {
    List<Character> charList = new ArrayList<>();
    List<Integer> counterList = new ArrayList<>();
    int p = 0;
    
    
    public StringIterator(String compressedString) {
        int i = 0;
        
        while(i < compressedString.length()){
            charList.add(compressedString.charAt(i));
            
            int j = i+1; //start with digit
            while(j < compressedString.length() && compressedString.charAt(j) <= '9' && compressedString.charAt(j) >= '0'){
                j++;
            }
            int c = Integer.parseInt(compressedString.substring(i+1, j));
            counterList.add(c);
            i = j;
        }
    }
    
    public char next() {
        char result = ' ';
        if (!hasNext()) return result;
        
        result = charList.get(p);
        counterList.set(p, counterList.get(p)-1);
        if(counterList.get(p) == 0){ p++; }
        
        return result;
        
    }
    
    public boolean hasNext() {
        return p < charList.size();
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
