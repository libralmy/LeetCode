public class Solution {
    /**add an '1' to the top digit of the binary string 
     * and reversely added the new number to the list.
     * initial list add(0)
     * for(i<n)
     *    for(j<size-1)
     *       list.add(list.get(j) + (int)Math.pow(2,i));****/
     
     
    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for(int twopow = 0 ; twopow<n ; twopow++){
            for(int iterate = result.size()-1 ; iterate>=0 ; iterate--){
                result.add(result.get(iterate) + (1<<twopow));//(int)Math.pow(2,twopow)
            }
        }
        
        return result;

    }
}
