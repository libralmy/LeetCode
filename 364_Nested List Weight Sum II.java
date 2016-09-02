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
public class Solution {
    
    /**
    *@param nestedList a given list of NestedInteger
    *@return depth * sum of NestedInteger for each level
    * 
    * [1, 2, [2, 3]]
    * get depth[] and weight it back order- (2+3) * depth[0](1),(1 +2) * depth[1](2)  
    * - extra space, hight time complexity
    * S1: DFS getDepthhelper(list, depth) maxD = Math.max()if it is NOT integer, (getList,depth+1)
    *     DFS: 
    *     for each level
    *       if it is intger, sum += getinteger * MaxDepth -depth +1
    *       else sum += dfs(getlist, depth+1)
    *     
    *     depth--;
    *       
    *       
    * 
    * Optimize: (1+2) been add up twice, so bring the previous level's sum to next level and add up again
    * sum in current level + previous sum 
    * 
    * S2: BFS: doesnt need to worry about depth
    *     
    *     prev = 0, curr = 0
    *     iterate the list
    *       
    *       build up a new list temp for saving previous level integers
    *       iterate current level
    *           if it is integer, curr += getInteger()
    *           else temp.addAll(getlist)
    *       prev += curr;
    *       nestedList = temp
    *       
    *     
    **/
   
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int prev = 0;
        int curr = 0;
        while(!nestedList.isEmpty()){
            List<NestedInteger> temp = new ArrayList<>();
            for(NestedInteger ni : nestedList){
                if(ni.isInteger()){
                    curr += ni.getInteger(); 
                }else{
                    temp.addAll(ni.getList());
                }
            }

            nestedList = temp;
            prev += curr;
            
        }
        
        
        return prev;
    }   
    public int maxDepth;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        getMaxDepth(nestedList, 1);
        return depthSumInversehelper(nestedList, 1);
    }
    
    public int depthSumInversehelper(List<NestedInteger> nestedList, int depth) {

        int sum = 0;
        for(NestedInteger ni : nestedList){
            if(ni.isInteger()){
                sum += ni.getInteger() * (maxDepth - depth +1);
            }else{
                sum += depthSumInversehelper(ni.getList(), depth+1);
            }
        }
        
        
        return sum;
    }
    
    public void getMaxDepth(List<NestedInteger> nestedList, int depth){
        maxDepth = Math.max(depth, maxDepth);
        for(NestedInteger ni : nestedList){
            if(!ni.isInteger()){
                getMaxDepth(ni.getList(), depth+1);
            }
        }
    }
 
}
