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
 * BST left < root < right, so use inorder 
 ***/
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){return 0;}
        
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if(k == 0){return root.val;}
            root = root.right;
            
        }
        
        return Integer.MIN_VALUE;
    }
}
