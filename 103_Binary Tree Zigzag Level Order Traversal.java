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
 * @return list of list zigzag tree 
 * 
 * BFS: 
 * use queue as temp storage
 * level start at 1
 * queue.add(root)
 * while(queue is not empty)
 * new Linkedlist cause it needs to add(0,temp.val))
 *      tempNode = queue.poll
 *      if level % 2 ==0  need to be reversed order
 *          list.add(0,temp.val)
 *      else list.add(temp.val)
 *      
 *      queue.offer left, right
 * 
 * result.add(list)
 * level++
 * 
 * DFS:
 * public list<>result
 * DFS(root, 0)
 * 
 * root == null returns
 * level >= result.size()  result.add(new Arrayli)
 * if(level % 2 ==0 ) result.get(level).add(root.val)
 * else result.get(level).add(0, root.val)
 * 
 * DFS left and right;
 * 
 **/
public class Solution {
    /*
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){return result;}
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for(int i = 0; i< size; i++){
                TreeNode tempNode = queue.poll();
                
                if(level % 2 == 0){
                    tempList.add(tempNode.val);
                }else{
                    tempList.add(0,tempNode.val);
                }
                if(tempNode.left != null){
                    queue.offer(tempNode.left);
                }
                if(tempNode.right != null){
                    queue.offer(tempNode.right);
                }
                
            }
            level++;
            result.add(tempList);
        }//end while
        return result;
    }*/
    
    
    List<List<Integer>> result;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        result = new ArrayList<List<Integer>>();
        if(root != null) zigzagLevelOrderDFS(root, 0);
        return result;
    }
    
    public void zigzagLevelOrderDFS(TreeNode root, int height) {
        if(root == null) return;
        if(height >= result.size()) result.add(new ArrayList<Integer>());
        
        if(height % 2 == 0) result.get(height).add(root.val);
        else result.get(height).add(0, root.val);
        
        zigzagLevelOrderDFS(root.left, height+1);
        zigzagLevelOrderDFS(root.right, height+1);
    }
}
