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
BFS level order traversal
**/
class Solution {
    /*
    public TreeNode invertTree(TreeNode root) {
        if(root == null){return null;}
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode r = queue.poll();
            TreeNode temp = r.left;
            r.left = r.right;
            r.right = temp;
            
            if(r.left != null){
                queue.add(r.left);
            }
            
            if(r.right != null){
                queue.add(r.right);
            }
        }
        
        
        return root;
    }*/
    public TreeNode invertTree(TreeNode root) {
        if(root == null){return null;}
        
        TreeNode left = root.left, right = root.right;
        
        root.left = invertTree(right);
        root.right = invertTree(left);
        
        return root;
        
    }    
    
}
