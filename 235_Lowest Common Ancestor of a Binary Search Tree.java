   /**BFT left always smaller than right
   so if p and q are smaller than root, then go deep to find LCA in left subtree, right side are same**/
   
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        if(root.val<Math.min(p.val,q.val)) return lowestCommonAncestor(root.right,p,q);
        if(root.val>Math.max(p.val,q.val)) return lowestCommonAncestor(root.left,p,q);
        return root;
    }
    

    
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || p == root || q == root){return root;}
        while(true){
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            }else if(root.val <p.val && root.val <q.val){
                root = root.right;
            }else{
                return root;
            }
        }
    }
    
    OR recursion
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null || p == root || q == root){return root;}

            if(root.val > p.val && root.val > q.val){
                return lowestCommonAncestor(root.left, p, q);
            }else if(root.val <p.val && root.val <q.val){
                return lowestCommonAncestor(root.right, p, q);
            }else{
                return root;
            }

    }
