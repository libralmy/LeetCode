/**
inorder traversal construction BST
DFS O(n)
if(l > h) return null
mid = l +(h-l)/2
new TreeNode(nums[mid])
left = dfs(l,mid-1)
right = dfs(mid+1, h)

***/
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){return null;}
        
        
        
        return dfs(nums, 0, nums.length -1);
    }
    
    public TreeNode dfs(int[] nums, int low, int high){
        if(low > high){return null;}
        
        int mid = low + (high-low)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(nums, low, mid-1);
        node.right = dfs(nums, mid+1, high);
        
        return node;
        
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
