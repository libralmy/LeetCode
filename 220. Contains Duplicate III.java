/**
* time complexity O(lg K)
* SortedSet<Long> => TreeSet<Long>
* ts.subSet(inclusive, exclusive)
* if(i >= k) ts.remove((long)nums[i-k]) manage the window
**/
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length < 2 || k < 0 || t < 0){return false;}
        
        SortedSet<Long> ts = new TreeSet<>();
        
        for(int i = 0; i < nums.length; i++){

            SortedSet<Long> ss = ts.subSet((long)nums[i]-t, (long)nums[i]+t+1);
            if(!ss.isEmpty()) return true;
            
            ts.add((long)nums[i]);
            
            if(i >= k) ts.remove((long)nums[i-k]);

        }
        
        
        return false;
    }
}
