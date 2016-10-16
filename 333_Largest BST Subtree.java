
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//O(nlongn)
    public int largestBSTSubtree(TreeNode root) {
            if(root == null) {
                return 0;
            }
            if(helper(root, Long.MIN_VALUE, Long.MAX_VALUE)) {
                return nodeCount(root);
            }
            int left = largestBSTSubtree(root.left);
            int right = largestBSTSubtree(root.right);
            return Math.max(left, right);
        }
        
        private int nodeCount(TreeNode root) {
            if(root == null) {
                return 0;
            }
            return nodeCount(root.left) + nodeCount(root.right) + 1;
        }
        
        private boolean helper(TreeNode root, long left, long right) {
            if(root == null) {
                return true;
            }
            if(root.val <= left || root.val >= right) {
                return false;
            }
            return helper(root.left, left, root.val) && helper(root.right, root.val, right);
        }

//O(n)
public class Solution {

    public int maxsize =0;
    public int minV;
    public int maxV;
    
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;

        lBSTsize(root);
        
        return maxsize;
    }
    
    public int lBSTsize(TreeNode root){
        if(root == null){

            return 0;
        }
        int res = -1;
        
        int lminV = root.val;
        int lmaxV = root.val;

        int lsize =lBSTsize(root.left);
        if(lsize > 0){
            lminV = minV;
            lmaxV = maxV;
        }
        
        int rminV = root.val;
        int rmaxV = root.val;

        int rsize = lBSTsize(root.right);
        if(rsize > 0){
            rminV = minV;
            rmaxV = maxV;
        }
        

        if(lmaxV > root.val || rminV < root.val){
            return -1;
        }
        if(lsize >= 0 && rsize >= 0){
            res = lsize + rsize +1;
            minV = lminV;
            maxV = rmaxV;
            maxsize = Math.max(maxsize, res);
        }
        
        return res;
        
    }
    

}
