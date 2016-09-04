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
     * @param root a given tree that need to serialized
     * @return a string that have a serialized tree
     *
     * serialize()
     * since return will be the string, use StringBuilder as the temp storage
     * splitsign, nullsign
     * iterate tree by layer in DFS
     *
     * if(root == null) +nullsign+spliter
     * else +root.val
     *      dfs(root.left, st)
     *      dfs(root.right, st)
     *
     * deserialize()
     * use the queue<String> as the temp storage for iterate and covert the string
     * queue.addAll(Arrays.asList(str.split(splitsign)))
     *
     * rebuild tree use DFS and return root
     * if queue.isEmpty return null
     * if queue.poll() == nullsign return null
     * root = Integer.parseInt(queue.poll())
     * root.left = DFS()
     * root.right = DFS()
     * **/
public class Codec {

    public static final String splitsign =",";
    public static final String nullsign = "#";
    public static  String serialize(TreeNode root) {
        if(root == null){ return "";}
        StringBuilder sb = new StringBuilder();
        sperializeHelper(root, sb);
        return sb.toString();
    }
    public static void sperializeHelper(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append(nullsign).append(splitsign);
            return;
        }
        if(root != null){
            sb.append(root.val).append(splitsign);
            sperializeHelper(root.left, sb);
            sperializeHelper(root.right, sb);
        }
    }
    public static TreeNode deserialize(String data) {
        if(data.length() == 0){return null;}
        
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(splitsign)));
        return deserializHelper(queue);
    }
    
    public static TreeNode deserializHelper(Queue<String> queue){
        if(queue.isEmpty()){return null;}
        if(queue.peek().equals(nullsign)){
            queue.poll();
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(queue.poll()));
        root.left = deserializHelper(queue);
        root.right = deserializHelper(queue);
        return root;        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
