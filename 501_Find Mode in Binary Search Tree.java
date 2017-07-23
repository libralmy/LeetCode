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
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    public int[] findMode(TreeNode root) {
        if(root == null){return new int[0];}
        List<Integer> result = new ArrayList<>();
        
        inorder(root);
        
        for(int key : map.keySet()){
            if(map.get(key) == max){result.add(key);}
        }
        
        int[] rs = new int[result.size()];
        for(int i = 0 ; i < result.size(); i++){
            rs[i] = result.get(i);
        }
        
        return rs;      
        
        
    }
    
    
    public void inorder(TreeNode root){
        if(root == null)return;
        
        if(root.left != null){inorder(root.left);}
        
        if(!map.containsKey(root.val)){
            map.put(root.val, 1);
        }
        map.put(root.val, map.get(root.val)+1);
        max = Math.max(max,map.get(root.val));
        if(root.right != null){inorder(root.right);}
    }
}
