
    /**
     * @param root-given TreeNode
     * @return List<List<Integer>> result- the leaf iteration of each level in the tree, from left to right
     * conner case: root == null?
     * S1: using BFS - iterate all the leaves from left to right, using queue to manage the order
     * S2: using BFS - iterate all the leaves from left to right, using queue to manage the order
     *                 instead forloop the size of queue, use while() and size-- at last
     * **/


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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //iterate whole tree: left -> right in each level
        while(!queue.isEmpty()){
            int size = queue.size();
            //add temp list for storing leafnode value
            List<Integer> tempList = new ArrayList<>();
            
            //iterate 
            for(int i = 0 ; i< size; i++){
                TreeNode tempNode = queue.poll();
                tempList.add(tempNode.val);
                if(tempNode.left != null){
                    queue.add(tempNode.left);
                }
                if(tempNode.right != null){
                    queue.add(tempNode.right);
                }
            }
            result.add(tempList);
        }
        
        
        return result;
    }
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> nodes = new ArrayList<>();
    if(root==null){
        return nodes;
    }
    
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    
    queue.add(root);
    
    while(queue.size()!=0){
        
        int size = queue.size();
        List<Integer> layer_vals = new ArrayList<Integer>();
        
        while(size!=0){
            TreeNode temp = queue.poll();
            layer_vals.add(temp.val);
            
            if(temp.left!=null)queue.add(temp.left);
            if(temp.right!=null)queue.add(temp.right);
            
            size--;
        }
        nodes.add(layer_vals);
    }
    
    return nodes;
}
   



}
