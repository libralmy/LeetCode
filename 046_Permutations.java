
    /**
    * @param nums a given int array
    * @return all the permutation
    * 
    * use backtracking
    * stop point: list.size() == nums.length result.add()
    * for iterate nums
    *   if(!used[])
    *       used[] =ture;//current is used
    *       temp.add()
    *       void dfs(boolean[] used, nums, templist, result)
    *       temp.remove(size-1)
    *       used[]=false;//reverse
    **/
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){return result;}
        dfs(result, new ArrayList<>(), new boolean[nums.length], nums);
        return result;
    }
    
    public void dfs(List<List<Integer>> result, List<Integer> tempList, boolean[] used, int[] nums){
        if(tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        for(int i = 0; i< nums.length; i++){
            if(!used[i]){
                used[i] = true;
                tempList.add(nums[i]);
                dfs(result, tempList, used, nums);
                tempList.remove(tempList.size()-1);
                used[i] = false;
            }
        }
    }
}
