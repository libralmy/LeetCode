
    /**
     * @param s an input string
     * @param t an input string that needs to compare with s is isomorphic
     * @return s and t is isomorphic or not
     *
     * S1: conner case: s.length()<=1 always true; pre-condistion is they have same length
     *      build a map that have reference between s.charAt and t.charAt
     *     it needs to check both key and value in one loop
     *     if(map.containsKey(si)) compare si and ti;
     *     else check !map.containsValue(ti) (<key, value> both doesnt exsit)map.put, or return F
     * S2: set two ASSIC map of array int[256] if two index of arry ==, both of them = i+1
     * **/
public class Solution {
/*
    public boolean isIsomorphic(String s, String t) {
        if(s.length() <=1){return true;}

        Map<Character, Character> map = new HashMap<>();
        for(int i = 0 ; i< s.length(); i++){
            char si = s.charAt(i);
            char ti = t.charAt(i);
            if(map.containsKey(si)){
                if(map.get(si) == ti){
                    continue;
                }else{
                    return false;
                }
            }else{
                if(!map.containsValue(ti)){
                    map.put(si, ti);
                }else{
                    return false;
                }
            }
        }
        return true;

    }*/


    public boolean isIsomorphic(String s, String t) {
        if(s.length() <=1){return true;}

        int[] letterMaps = new int[256];
        int[] letterMapt = new int[256];
        for(int i = 0; i< s.length(); i++){
            if(letterMaps[s.charAt(i)] == letterMapt[t.charAt(i)]){
                letterMaps[s.charAt(i)] = i+1;
                letterMapt[t.charAt(i)] = i+1;
            }else{
                return false;
            }
        }
        return true;
    }

}
