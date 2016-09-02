
    /**
    *@param s a given string 
    *@return list of string that 
    * 
    * substring(i, i+10) i<=length-10
    * build two set, one is for result, one is for findrepeat
    * if want to find a subset that is duplicated, use findrepeat.add() => boolean & action
    * return new ArrayList<>(result) => hashset covert to list
    **/
public class Solution {
    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        Set<String> findRepeat = new HashSet<>();
        
        for(int i = 0; i < s.length()-9; i++){
            if(!findRepeat.add(s.substring(i, i+10))){
                result.add(s.substring(i, i+10));
            }
        }
        return new ArrayList<>(result);

    }
    
    
    public List<String> findRepeatedDnaSequences(String s) {
    List<String> list = new ArrayList<String>();
    if (s == null || s.length() < 10) return list;
    HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    
    for (int i = 0; i + 10 <= s.length(); i++ ) {
        int hash = stringToHash(s.substring(i, i + 10));
        if (map.containsKey(hash)) {
            if (!map.get(hash)) {
                list.add(s.substring(i, i + 10));
                map.put(hash, true);
            }
        } else {
            map.put(hash, false);
        }
    }
    return list;
}

private int stringToHash (String s) {
    String numberBuilder = "";
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == 'A') numberBuilder += "0";
        if (s.charAt(i) == 'C') numberBuilder += "1";
        if (s.charAt(i) == 'G') numberBuilder += "2";
        if (s.charAt(i) == 'T') numberBuilder += "3";
    }
    return Integer.parseInt(numberBuilder, 4);
}
}
