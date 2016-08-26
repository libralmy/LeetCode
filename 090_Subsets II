    /************path safe checking: 
    if(i>start && nums[i] == nums[i-1]) skip this status, 
    continue the for loop***************/

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(result, new ArrayList<>(), nums, 0);
        return result;

    }
    public static void backtracking(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start){
        result.add(new ArrayList<>(tempList));

        for(int i = start; i < nums.length ; i++){
            if(i>start && nums[i] == nums[i-1]){continue;}
            tempList.add(nums[i]);
            backtracking(result, tempList, nums, i+1);
            tempList.remove(tempList.size()-1);
        }
    }
    
        /*
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums); // make sure subsets are ordered
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>()); // start with empty set
    int begin = 0;
    for (int i = 0; i < nums.length; i++) {
        if(i == 0 || nums[i] != nums[i - 1]) begin = 0;
        int  size = result.size();
        for (int j = begin; j < size; j++) { // remember
            List<Integer> subset = new ArrayList<>(result.get(j)); // copy a new one
            subset.add(nums[i]); // expand
            result.add(subset); // collect
        }
        begin = size;
    }
    return result;
    }
    */
