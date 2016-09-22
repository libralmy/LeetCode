
 /**
 * BFS
 * using queue as temp storage
 * conner case: root == null, l =null & | r = null
 * push l and r into queue before while(!queue.isEmpty())
 * poll() get l and r
 * if(both l.l and r.r not null) push them
 * else one of is null return false
 * if(both l.r and r.l not null) push them
 * else one of is null return false
 * 
 * DFS:(left, right)
 * if(root) return true
 * return dfs(left, right)
 * if(both null) return true
 * if(one of is null) return false
 * return l.val = r.val && dfs(l.l, r.r) && dfs(l.r, r.l)
 **/
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return dfs(root.left, root.right);
    }
    
    public boolean dfs(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        
        return (left.val == right.val)&& dfs(left.left, right.right) && dfs(left.right, right.left); 
    }

    public boolean isSymmetric(TreeNode root) {

        if(root == null){
            return true;
        }else if(root.left ==null && root.right ==null){
            return true;
        }else if(root.left == null || root.right == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        
        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left.val != right.val){ return false;}
            if(left.left != null && right.right != null){
                queue.offer(left.left);
                queue.offer(right.right);
            }else if((left.left != null && right.right == null) || (left.left == null && right.right != null) ){
                return false;
            }
            
            if(left.right != null && right.left != null){
                
                queue.offer(right.left);
                queue.offer(left.right);
            }else if((left.right != null && right.left == null) || (left.right == null && right.left != null) ){
                return false;
            }
        }
        return true;

    }
}
