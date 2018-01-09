
/***
this.nums = nums;
r = new Random();
int idx = r.nextInt(i+1);
swap(temp, idx, i);
**/
class Solution {
    int[] nums;
    Random r;
    
    public Solution(int[] nums) {
        this.nums = nums;
        r = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(nums == null){return null;}
        int[] temp = nums.clone();
        
        for(int i = 0; i < nums.length; i++){
            
            int idx = r.nextInt(i+1);
            swap(temp, idx, i);
                
        }
        
        return temp;
    }
    public void swap(int[] temp, int a, int b){
        int t = temp[a];
        temp[a] = temp[b];
        temp[b] = t;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
