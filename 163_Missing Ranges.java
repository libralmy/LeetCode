
public class Solution {
    /**
     * @param nums a sorted integer array
     * @param lower an integer
     * @param upper an integer
     * @return a list of its missing ranges
     * 
     * helper function(list, (long)low, (long)up) 
     * main function three parts
     * conner case nums[] == null
     * 1 lower compare (long)num[0]-1
     * 2 (long)num[i]+1 compare (long)num[i+1]-1
     * 3 (long)num[len-1] compare upper
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // Write your code here
        List<String> result = new ArrayList<>();
        
        
        if(nums.length == 0){
            getInterval(result, lower, upper);
            return result;
        }
        
        getInterval(result, lower, (long)nums[0]-1);
        
        for(int i = 1; i < nums.length; i++){
            
            getInterval(result, (long)nums[i-1]+1, (long)nums[i]-1);
        }
        
        
        getInterval(result, (long)nums[nums.length-1]+1, upper);
        
        return result;
        
    }
    
    
    public void getInterval(List<String> result, long lower, long upper){
        if(lower > upper){
            return;
        }


        if(lower == upper){
            result.add(lower +"");
            return;
        }
        
        result.add("" + lower +"->" + upper);

    }
}

/**
* @param nums a given int array that missing range
* @param lower a given int lower bound
* @param upper a given int upper bound
* @output a list of string that include all missing range
* use stringbuilder to record each gap of range
**/

public class Solution {
   
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();

        int next = lower;
        
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] > upper) result.add(getRange(next, upper));
            if(nums[i] == upper) result.add(getRange(next, nums[i]-1));
            
            if(nums[i] < next || (i>0 && nums[i] == nums[i-1])){ continue;}
            
            if(nums[i] == next){ 
                next++;
                continue;
            }
            
            result.add(getRange(next, nums[i]-1));
            next = nums[i]+1;
        }
        
        if(next <= upper){result.add(getRange(next, upper));}
        
        return result;
    }
    
    public String getRange(int a, int b){
        StringBuilder sb = new StringBuilder();
        
        return a == b? sb.append(a).toString(): sb.append(a).append("->").append(b).toString();
        //return a == b? String.valueOf(a) : String.format("%d->%d",a,b);
        
    }
    
    
 public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> list = new ArrayList<String>();
    if(nums == null) return list;
    int n = nums.length;
    
    for(int i = 0; i <= n; i++) {
        int lt =0, gt=0;
        
        if(i==0)
            lt = lower;
        else
            if(nums[i-1]==Integer.MAX_VALUE)
                break;
            else
                lt = nums[i-1]+1;
        
        if(i==n)
            gt = upper;
        else
            if(nums[i]==Integer.MIN_VALUE)
                continue;
            else
                gt = nums[i]-1;

        addRange(list, lt, gt);
    }
    return list;
}

private void addRange(List<String> list, int lo, int hi) {
    if(lo > hi) return;
    else if(lo == hi) list.add(String.valueOf(lo));
    else list.add(lo + "->" + hi);
}
    
    
}
