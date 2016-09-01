/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
* S1: stack - leftNode
* constructor: build up a stack that store all the left node, 
* if it doesnt have left node anymore, break the loop 
* 
* hasnext() - check the stack is empty
* 
* next() - pop node to tempNode, and check same level of right node is there or not
*          do the same thing as build up constructor, push all the left node into stack
* 
* S2: Queue - Inorder Traversal
* Constructor  - build up a queue that store all the node base on in order
* 
* hasnext() - check the queue is empty
* 
* next() - queue.poll().val
* 
**/
/*
public class BSTIterator {
    public Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode temp = root;
        while(temp != null){
            stack.push(temp);
            if(temp.left != null){
                temp = temp.left;
            }else{
                break;
            }
        }
        
    }

    //@return whether we have a next smallest number
    public boolean hasNext() {
        return !stack.isEmpty();

    }

    /// @return the next smallest number 
    public int next() {
        TreeNode tempTNode = stack.pop();
        TreeNode curr = tempTNode;
        
        if(curr.right != null){
            curr = curr.right;
            while(curr != null){
                stack.push(curr);
                if(curr.left != null){
                    curr = curr.left;
                }else{
                    break;
                }
            }
        }
        return tempTNode.val;
    }
}
*/


public class BSTIterator {
    public Queue<TreeNode> queue;
    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        inOrderTraversal(root);
    }
    
    public void inOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        
        if(root.left != null){
            inOrderTraversal(root.left);
        }
        
        queue.add(root);
        
        if(root.right != null){
            inOrderTraversal(root.right);
        }
       
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {

        return !queue.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll().val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
