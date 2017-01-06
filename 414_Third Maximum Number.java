/**
*long small, mid, max = Long.MIN_VALUE
if count >= 3 return small, else return max;
***/
public class Solution {
    public int thirdMax(int[] nums) {
        if(nums == null || nums.length == 0){return 0;}
        
        long small = Long.MIN_VALUE,mid = Long.MIN_VALUE, max = Long.MIN_VALUE;
        int count = 0;
        
        for(int n : nums){
            if(n == max || n == mid){continue;}
            
            if(n > max){
                
                small = mid;
                mid = max;
                max = n;
                count++;
            }else if(n > mid){
                small = mid;
                mid = n;
                count++;
                
            }else if(n >= small){
                small = n;
                count++;
            }
            
            
        }
        
        if(count >= 3){
            return (int)small;
        }else{
            return (int)max;
        }
        
    }
}    




public int thirdMax(int[] nums) {
        if(nums == null || nums.length == 0){return 0;}

        PriorityQueue<Integer> pq = new PriorityQueue<>(4);
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i< nums.length; i++){
            if(!set.contains(nums[i])){
                pq.add(nums[i]);
                set.add(nums[i]);
                if(pq.size() > 3){
                    set.remove(pq.poll());
                }
            }
        }
        
        
        if(pq.size() < 3){
            while(pq.size() > 1){
                pq.poll();
            }
        }
        return pq.peek();
    }

