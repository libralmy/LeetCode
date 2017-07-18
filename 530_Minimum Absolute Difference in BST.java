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
 * @param a given BST treenode
 * @return min difference
 * since it is BST, using in order traversal will be sorted
 *
 */
public class Solution {
    int result = Integer.MAX_VALUE;
    TreeNode prev;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return result;
    }
    
    
    public void inorder(TreeNode root){
        if(root == null){return;}
        
        inorder(root.left);
        
        if(prev != null){ result = Math.min(result, Math.abs(prev.val - root.val));}
        prev = root;
        
        inorder(root.right);
    }
}
