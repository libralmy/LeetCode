class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        int i = 0, j = 0;
        int[] result = new int[A.length];
        
        while(i < A.length){
            if(A[i] == B[j]){
                result[i] = j;
                i++;
                j=0;
            }else{
                j++;
            }
            
        }
        
        return result;
    }
}
