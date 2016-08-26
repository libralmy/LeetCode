/**************/
remove the duplicates
if(i> start && candidates[i] == candidates[i-1]){continue;}
/**************/
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
                if(i> start && candidates[i] == candidates[i-1]){continue;}
                tempList.add(candidates[i]);
                backtracking(result, tempList, candidates, remain - candidates[i],i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }
