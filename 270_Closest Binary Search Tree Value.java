/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int closestValue(TreeNode root, double target) {
    
        if(root == null ){return 0;}
        int result = root.val;
        while(root != null){
            
            result = Math.abs(target - root.val) < Math.abs(target - result)? root.val : result;
            
            
            if(target < root.val){
                root = root.left;
            }else if(target > root.val){
                root = root.right;
            }else{
                result = root.val;
                break;
                
            }
        }
        

        return result;
        
    }
}
