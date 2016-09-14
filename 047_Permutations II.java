
    /**
    * @param nums a given int array that contains duplicates numbers
    * @return List<List<>> that contains unique permutation
    * 
    * backtracking [1]+[1,2],[2]+[1,1]
    * nums need to be sorted before using, [1,2,1]then could adjust iteration
    * stop point: tempList.size() == nums.length
    * iteration nums 
    * current is been used, continue
    * (i>0) and previous one is euqal to current one, in the mean time previous one is not finished backtracking,continue
    * if(used[i] || i>0 && nums[i-1] == nums[i] && !used[i-1] ) continue;
    **/
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }
    
    public void backtracking(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used){
        if(tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue; //[112] all the repeat combination
            if(i >0 && !used[i-1] && nums[i] == nums[i-1]) continue; // !used[i-1] previous one is not finish backtracking yet
            
            used[i]= true;
            tempList.add(nums[i]);
            backtracking(result, tempList, nums, used);
            tempList.remove(tempList.size() -1);
            used[i] = false;
        }
    }

}
