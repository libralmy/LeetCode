
    /**
    * @param a int 
    * @return all the factors that n has
    * 
    * backtracking DFS (result, tempList, n, start)
    * (result, templist, n/i, i)
    * stop point: 
    *   n<=1
    *       temp.list()>1 (16*1 will not be count)
    *   returns
    * 
    * i= start, i<=n(make sure no[8,2]), i++
    *   if(n%i)
    *       temp+
    *       (result, templist, n/i, i) <= [2,2,2,2],[2,2,4],[2,8],[4,4]
    *       temp-
    * 
    **/
  public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        getFactorsDFS(result, new ArrayList<>(), n, 2);
        return result;
    }
    
    public void getFactorsDFS(List<List<Integer>> result, List<Integer> tempList, int n, int start){
        if(n <= 1){
            if(tempList.size()>1){
                result.add(new ArrayList<>(tempList));
            }
            return;
        }
        
        for(int starti = start; starti <= n; starti++){
            if(n%starti == 0){
                tempList.add(starti);
                getFactorsDFS(result, tempList, n/starti, starti);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
