

    /**
    *@param nestedList a given list of NestedInteger
    *@return the weighted = depth * sum of each level
    * 
    * S1: BFS 
    * peel the list layer by layer, if meet integer then sum += int * depth
    * if meet list add into templist
    * assign temp list back to nestedlist
    * S2: DFS
    *     depth start at 1
    *     int helper() iterate list
    *                  if it is integer, sum += depth * integer
    *                  else sum+=helper()
    **/
public class Solution {

   
    public int depthSum(List<NestedInteger> nestedList) {
        
        int depth = 1;
        int sum = 0;
        
        while(!nestedList.isEmpty()){
            List<NestedInteger> temp = new ArrayList<>();
            
            for(NestedInteger ni : nestedList){
                if(ni.isInteger()){
                    sum += ni.getInteger() * depth;
                }else{
                    temp.addAll(ni.getList());
                }
            }
            
            depth++;
            nestedList = temp;
        }
        return sum;
    }
    
    
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null) return 0;
        
        return depthSumhelper(1, nestedList);

    }
    public int depthSumhelper(int depth, List<NestedInteger> nestedList){
        int sum =0;
        for(NestedInteger ni : nestedList){
            if(ni.isInteger()){
                sum += ni.getInteger() * depth;
            }else{
                sum +=depthSumhelper(depth+1, ni.getList());
            }
        }
        return sum;
    }

    
}
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
