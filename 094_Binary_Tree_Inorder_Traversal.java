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
    /**
    * inorder traversal left root right
    **/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if(root == null) return result;
        //dfs(result, root);
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root!= null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        
        return result;
    }
    
    public void dfs(List<Integer> result, TreeNode root){
        if(root != null){
            if(root.left != null) dfs(result, root.left);
            result.add(root.val);
            if(root.right != null) dfs(result, root.right);
        }
    }
}
