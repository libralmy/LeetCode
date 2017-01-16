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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> tempList = new ArrayList<>();
            
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                tempList.add(temp.val);
                
                if(temp.left!= null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            
            result.add(0, tempList);
             
        }
        
        return result;
    }
}
