/************************/
Backtracking can be solved always as follows:

Pick a starting point.
while(Problem is not solved)
    For each path from the starting point.
        check if selected path is safe, if yes select it
        and make recursive call to rest of the problem
        before which undo the current move.
    End For
If none of the move works out, return false, NO SOLUTON.
/*********************************/



public class Solution {

   //backtracking
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(result, new ArrayList<>(), nums, 0);
        return result;

    }
    public static void backtracking(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start){
        result.add(new ArrayList<>(tempList));

        for(int i = start; i < nums.length ; i++){
            tempList.add(nums[i]);
            backtracking(result, tempList, nums, i+1);
            tempList.remove(tempList.size()-1);
        }
    }

    
    /*
    //backtracking + DFS
   public static List<List<Integer>> subsets(int[] nums) {  
        List<List<Integer>> ll = new ArrayList<List<Integer>>();  
        Arrays.sort(nums);  
        dfs(nums, new ArrayList<Integer>(), 0, ll);  
        return ll;  
    }  
  
    private static void dfs(int[] nums, ArrayList<Integer> l, int i, List<List<Integer>> ll) {  
        if (i == nums.length) {  
            ll.add((List<Integer>) l.clone());  
            return;  
        }  
        l.add(nums[i]);  
        dfs(nums, l, i + 1, ll);  
        l.remove(l.size() - 1);  
        dfs(nums, l, i + 1, ll);  
    } */
}
