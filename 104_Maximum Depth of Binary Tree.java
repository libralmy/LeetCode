/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    /**
    *@param root: a given tree
    *@return int: max depth of tree
    * 
    * BFS: use queue to be the temp storage
    *      iterate push the leaves to the queue for each level
    *      check left, right node, if one of them is not null, then depth++
    *      till no leaf is been pushed to queue
    * 
    * DFS: recursive 
    *      if(root == null) return 0;
    *      leftMax = maxDepth(root.left)+1
    *      rightMax = maxDepth(root.right)+1
    *      return max(leftmax, rightmax)
    **/
    /*
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){return 0;}
        else if(root.left == null && root.right == null){ return 1;}
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
            depth++;
            
        }
        
        return depth;
        
    }*/
    public int maxDepth(TreeNode root) {
        if(root == null){return 0;}
        
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    
}
