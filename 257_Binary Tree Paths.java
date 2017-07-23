/**
 *if(root.left == null && root.right == null){result.add(path + root.val);}
 * path + root.val + "->"
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> result = new ArrayList<>();
        if(root == null){return result;}
        inorder(root, result, "");
        
        return result;
    }
    
    
    public void inorder(TreeNode root, List<String> result, String path){
        if(root.left == null && root.right == null){result.add(path + root.val);}
        
        if(root.left != null){ inorder(root.left, result, path + root.val + "->");}
        
        if(root.right != null){ inorder(root.right, result, path + root.val + "->");}
        
    }
}
