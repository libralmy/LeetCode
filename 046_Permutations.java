
    /**
    * @param nums a given int array that contains the basic permutation
    * @return all the permutations as a List<List<>>
    * 
    * [1]+[2,3] ,[2]+[1,3], [3]+[1,2]
    * backtracking
    * templist for each level, and boolean[] same length as given array for avoid the duplications
    * stop point: templist.size() == nums.length
    * 
    * iteration of nums
    * if(!used[]) => backtarcking
    **/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {  
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }  
    
    public void backtracking(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used){
        if(tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(!used[i]){
                used[i]=true;
                tempList.add(nums[i]);
                backtracking(result, tempList, nums, used);
                tempList.remove(tempList.size()-1);
                used[i]=false;
            }
        }
    }
    
        /*
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0) return result;

        List<Integer> inResult = new ArrayList<>();
        inResult.add(nums[0]);
        result.add(inResult);
        //for result
        for(int i = 1; i<nums.length ; i++){
            List<List<Integer>> tempResult = new ArrayList<>();
            //for current tempinResult
            for(int j = 0; j<=i; j++){
                for(List<Integer> loopList: result){
                    List<Integer> tempinResult = new ArrayList<>(loopList);
                    tempinResult.add(j,nums[i]);
                    tempResult.add(tempinResult);
                }
            }
            result = tempResult;
        }

        return result;
    }*/

}
