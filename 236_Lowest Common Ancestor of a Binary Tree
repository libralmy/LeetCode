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
     * @param root  the given tree
     * @param p given treenode
     * @param q given treenode
     * @return the LCA 
     * 
     * S1 Divide and Conquer
     * if(root == null || p == root || q == root) return root
     * Divide into two part
     * leftNode go deapth of leftside
     * rightNode to deapth of rightside
     * if return both side contains nodes, then root is the parent
     * else which side is null, then the parent node is the other side node
     * 
     * S2iteration: BFS
     * Build up a Map<childNode, parantNode> if map doesnt not contain p or q
     * Build up a Queue<node of current level> make sure the node is not null then start its level of iteration
     * 
     * Build up a Set<Parent of p>
     * use the Set to find the q's parent that same as p
     * 
     * return q
     * **/
public class Solution {    
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Devide conquer
        
        if(root == null || p == root || q == root){
            return root;
        }
        //devide
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        
        //conqure
        if(leftNode != null && rightNode != null){
            return root;
        }
        return leftNode == null? rightNode: leftNode;
    }
       

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null ){return null;}
        Map<TreeNode, TreeNode> mapofParent = new HashMap<>();
        Queue<TreeNode> queueCurrL = new LinkedList<>();
        mapofParent.put(root, null);
        queueCurrL.add(root);
        
        while(!mapofParent.containsKey(p) || !mapofParent.containsKey(q)){
            TreeNode tempTNode = queueCurrL.poll();
            if(tempTNode != null){
                mapofParent.put(tempTNode.left, tempTNode);
                mapofParent.put(tempTNode.right, tempTNode);
                queueCurrL.add(tempTNode.left);
                queueCurrL.add(tempTNode.right);
            }
        }
        
        Set<TreeNode> pParent = new HashSet<>();
        while(p!=null){
            pParent.add(p);
            p = mapofParent.get(p);
        }
        while(!pParent.contains(q)){
            q = mapofParent.get(q);
        }
        return q;
        
    }
    
}
