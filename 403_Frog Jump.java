public class Solution {
    /**
    * bruce force to get the path
    * recursion the whole array and iterate [k-1, k, k+1]
    * use Arrays.binarysearch(arr, fromidx, toidx, target)
    **/
    public boolean canCross(int[] stones) {
        int k = 0;
        return helper(0, stones, k);
    }
    
    public boolean helper(int index, int[] stones, int k){
        if(index == stones.length -1) return true;
        
        for(int i = k-1; i <= k+1; i++){
            int position = Arrays.binarySearch(stones, index+1, stones.length, stones[index]+i);
            if(position > 0){
                if(helper(position, stones, i)) return true;
            }
        }
        return false;
    }
}
