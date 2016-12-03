
    /**
     * @param root: given a tree node
     * @return List<Integer> : return a Integer list that only contains right side of view
     * S1: O(n)using BFS to check rightNode first -> add into queue, and then leftNode.
     *     add into result before poll() in the forloop
     * S2: O(logn)-O(n)using DFS to go deepth of right side tree
     * check has right node or not first, if not, then go check left node 
     * add treenode.value into list when depth == result.size()
     * */
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
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if(root == null){return result;}
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            result.add(queue.peek().val);
            for(int i = 0 ; i< size; i++){
                TreeNode temp = queue.poll();
               
                if(temp.right != null){
                    queue.offer(temp.right);
                }
                if(temp.left != null){
                    queue.offer(temp.left);
                }
            }
            
        }
        return result;
        
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if(root == null){return result;}
        helper(result, root, 0);
        return result;
        
    }
    
    public void helper(List<Integer> result, TreeNode root, int depth){
        if(root == null){return;}
        
        if(depth == result.size()){
            result.add(root.val);
        }
        
        if(root.right != null){helper(result, root.right, depth+1);}
        if(root.left != null){helper(result, root.left, depth+1);}
    }
}
