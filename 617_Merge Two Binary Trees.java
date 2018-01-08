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
*pre order traversal
check t1 and t2 both null, or any of them is null
**/
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return null;
        }else if(t1 == null){
            return t2;
        }else if(t2 == null){
            return t1;
        }
        
        int nodeVal = (t1==null? 0 : t1.val) + (t2==null? 0 : t2.val);
        
        TreeNode newNode = new TreeNode(nodeVal);
        
        newNode.left = mergeTrees(t1.left, t2.left);
        newNode.right = mergeTrees(t1.right, t2.right);
        
        return newNode;
        
        
        
    }
}
