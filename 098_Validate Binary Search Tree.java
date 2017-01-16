

    /**
    * @param root a given BST
    * @return check is valid BST
    * DfS: O(logn)
    * dfs(root, Integer l, Integer r)
    * if(l !=null && root.val <= l)return false
    * return dfs(ro.l, l, ro.val) && dfs(ro.r, ro.val, r)
    * 
    * Iteration: O(n)
    * BST: all left small than root, root small than right-> Inorder traversal
    * set a preNode = null and currNode as pointer
    * using stack as temp storage, top is the smallest
    * push all left node to stack
    * temp pop()  is the parent of preNode
    * assign preNode = temp; curr = curr.right;
    **/
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null){return true;}
        
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean helper(TreeNode root, long minval, long maxval){
        if(root == null){return true;}
        
        if(root.val <= minval || root.val >= maxval){
            return false;
        }

        
        return helper(root.left, minval, root.val) && helper(root.right, root.val, maxval);
    }
}


public boolean isValidBST(TreeNode root) {
   if (root == null) return true;
   Stack<TreeNode> stack = new Stack<>();
   TreeNode pre = null;
   while (root != null || !stack.isEmpty()) {
      while (root != null) {
         stack.push(root);
         root = root.left;
      }
      root = stack.pop();
      if(pre != null && root.val <= pre.val) return false;
      pre = root;
      root = root.right;
   }
   return true;
}
