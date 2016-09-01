    /**
     * @param root a given treenode
     * @return a List<List<Integer>> level order traversal for each level
     * 
     * BFS: using a queue as the temp storage
     *      input the root, and check left node , right node, 
     *      save them in the templist for each level
     *      add templist into result
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


}
