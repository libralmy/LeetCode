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
 * @param root a given tree
 * @return upsideDowntree -> left
 *                       right   root
 * 
 * left => root, root => right, right => left
 * so start from root.left
 * 
 * rootP = root;
 * preLeft = null;
 * preright = null;
 * preroot = null;
 * while loop 
 * preleft <-root.left <- preright <- root.right <- preRoot <- root
 * 
 * return preRoot 
 * 
 **/
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode rootP = root;
        TreeNode preLeft = null;
        TreeNode preRight = null;
        TreeNode preRoot = null;
        
        while(rootP != null){
            preLeft = rootP.left;
            rootP.left = preRight;
            preRight = rootP.right;
            rootP.right = preRoot;
            preRoot = rootP;
            rootP = preLeft;
        }
        return preRoot;
    }
}
