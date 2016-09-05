/**
* @param root a given tree
* @return the bottom-up leaves
* 
* use DFS, keep latest bottom of leaves as a group, The level of a node is also the its index in the result list (res)
* if(root == null) return -1; level start at 0
* 
* leftbottomlevel = helper(left, level+1)
* rightbottomlevel = 
* level = max(leftbottom, rightbottom) +1
* 
* if(root =res.size() ) res.add(new list)
* res.get(level).add(root.val)
* ////if need to remove leaves root.left = root.right = null;
* return level
**/
public class Solution {
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root != null) helper(result, root);
        return result;
    }
    public int helper(List<List<Integer>> result, TreeNode root){
        if(root == null){return -1;}
        int leftbottom = helper(result, root.left);
        int rightbottom = helper(result, root.right);
        
        int level = Math.max(leftbottom, rightbottom) +1;
        
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        //remove tree leaf
        root.left = null;
        root.right = null;
        
        return level;
    }
}
