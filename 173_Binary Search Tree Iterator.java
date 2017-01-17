/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    public Stack<TreeNode> stack;
    public TreeNode temp;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        temp = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || temp != null;
    }

    /** @return the next smallest number */
    public int next() {
            while(temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            int n = temp.val;
            temp = temp.right;
            
            return n;

    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
