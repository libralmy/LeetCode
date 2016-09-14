

    /**
    * @param strs a given string array
    * @return group anangrams
    *  O(m*log(m)) Arrays.sort() * n
    //Str.toLowerCase() 
    * it just the diffrent combationation of array, so when the string is sorted, it should be all same in one group
    * Map<sorted str as key, iterated str as list>
    * iterate each string in the array
    *   str.toCharArray => sorted
    *   ! Map.contain(sorted str) 
    *       add a new list
    *   put a new arraylist in map
    * return map.values as a list<list<>>
    **/
 public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        if(strs == null || strs.length == 0){return result;}
        
        for(String str : strs){
            char[] tempCharArr = str.toCharArray();
            Arrays.sort(tempCharArr);
            String strkey = String.valueOf(tempCharArr);
            if(!map.containsKey(strkey)){
                map.put(strkey, new ArrayList<>());
            }
            map.get(strkey).add(str);
        }
        result.addAll(map.values());
        return result;
    }
}
