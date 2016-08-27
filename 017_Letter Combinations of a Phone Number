public class Solution {
    
    /**S1 TC: (avg of value)pow digits.length
     * put all the mapping<char, "string at number">
     * initialize return result and stringbuilder
     * user DFS and backtracking to do the permutation
     * DFS is the loop of digits.length
     *      so every end point should be start == digits.length
     *      else get the string value of current digit 
     *      use backtracking to get the permutation for the strins**/
     /*
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.isEmpty()){return result;}
        Map<Character, String> numMap = new HashMap<>();
        numMap.put('0', "");
        numMap.put('1', "");
        numMap.put('2', "abc");
        numMap.put('3', "def");
        numMap.put('4', "ghi");
        numMap.put('5', "jkl");
        numMap.put('6', "mno");
        numMap.put('7', "pqrs");
        numMap.put('8', "tuv");
        numMap.put('9', "wxyz");
        
        StringBuilder s = new StringBuilder();

        DFS(result, s, 0, digits, numMap);

        return result;

    }

    public static void DFS(List<String> result, StringBuilder s, int start, String digits, Map<Character, String> numMap){
        if(start == digits.length()){
            result.add(s.toString());//add current stringbuilder permutation to the list
        }else{
            String temp = numMap.get(digits.charAt(start));// get the value of map
            for(int i = 0; i < temp.length(); i++){
                s.append(temp.charAt(i));
                DFS(result, s, start+1, digits, numMap);
                s.deleteCharAt(s.length() - 1);
            }
        }
    }
    
    */
    
/**S2
 * initialize mapping in the string array{"0", "1".....}
 * use linkedlist to store result
 * result.add("")
 * forloop of length of digit
 *      convert char to int for mapping the string in the array(Character.getNumericValue(char))
 *      whileloop control the head's length should be the length of each permutation(result.peek().length() == i)
 *      ***i = 0, add first mapping, i = 1, add second mapping, after finish while loop, length of permutation will be digit.length(), i always smaller than that***
 *          pop the head as the first element of permutation
 *              add(head + C31) in string[convert by char] forloop **/
    public static List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if(digits.equals("")) return result;
        String[] map = new String[]{ "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        result.add("");//will pop same as queue loop

        for(int i=0; i<digits.length(); i++){
            int indexofmap = Character.getNumericValue(digits.charAt(i));//get index of mapping array
            while(result.get(0).length() == i){
                String temp = result.remove(0);//remove head
                for(char elem : map[indexofmap].toCharArray()){
                    result.add(temp + elem);
                }
            }
        }
        return result;
    }
    
}
