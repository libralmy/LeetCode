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
 * @return boolean find it is Symmetric tree or not
 * 
 * DFS:
 * isSameTreehelper(root.left, root.right)
 * if(left==null && right ==null) return true
 * if(one if is null) return false
 * return(l.val == r.val)&& l.l, r.r && l.r, r,l
 * 
 * Iteration:BFS
 * use queue to be the temp storage
 * 
 * queue.add(left)
 * queue.add(right)
 * 
 * NO forloop for size!!
 * two general conditions
 * a l.l!=null && r.r!=null
 * b l.r!=null && r.l!=null
 **/
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }else if(root.left == null && root.right == null){
            return true;
        }else if(root.left == null || root.right == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root.left);
        queue.add(root.right);
        
        while(!queue.isEmpty()){

                TreeNode l = queue.poll();
                TreeNode r = queue.poll();
                if(l.val != r.val){ return false;}
                
                if(l.left != null && r.right != null){
                    queue.add(l.left);
                    queue.add(r.right);
                }else if((l.left != null && r.right == null) || (l.left == null && r.right != null)){
                    return false;
                }
                
                if(l.right != null && r.left != null){
                    queue.add(l.right);
                    queue.add(r.left);
                }else if((l.right == null && r.left != null) || (l.right != null && r.left == null)){
                    return false;
                }

        }
        
        return true;
        
    }
    
    /*
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return left == right;
        }
        if(left == null || right == null){
            return false;
        }
        return (left.val == right.val)&& helper(left.left, right.right) && helper(left.right, right.left);
    }*/
}
