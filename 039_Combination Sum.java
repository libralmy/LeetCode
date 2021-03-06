
/***
sorted array first
remain<0 => return; remain == 0 find it add to the new Arraylist; else forloop backtracking
start doesnt need to +1, because it needs to use same number
add remain = target - nums[i]*****/

public class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(result, new ArrayList<>(), candidates, target,0);
        return result;

    }
    public static void backtracking(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain,int start){
        if(remain<0){
            return;
        }else if(remain == 0){
            result.add(new ArrayList<>(tempList));
        }else {
            for (int i = start; i < candidates.length; i++) {

                tempList.add(candidates[i]);
                backtracking(result, tempList, candidates, remain - candidates[i],i);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
