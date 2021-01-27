public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            sb.append(node.val + " ");
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "")
            return null;
        Deque<String> deque = new LinkedList<>();
        deque.addAll(Arrays.asList(data.split(" ")));
        return listToTree(deque);
    }
    
    private TreeNode listToTree(Deque<String> deque) {
        TreeNode root = new TreeNode(Integer.valueOf(deque.poll()));
        TreeNode ptr;
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            ptr = root;
            int val = Integer.valueOf(deque.poll());
            
            while (ptr != null) {
                if (val < ptr.val) {
                    if (ptr.left == null) {
                        ptr.left = new TreeNode(val);
                        break;
                    } else
                        ptr = ptr.left;
                } else {
                    if (ptr.right == null) {
                        ptr.right = new TreeNode(val);
                        break;
                    } else
                        ptr = ptr.right;
                }
            }
        }
        return root;
    }
}



public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty())
            return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
                                               
    private TreeNode deserialize(Queue<String> queue, int min, int max) {
        if (queue.isEmpty())
            return null;
        String s = queue.peek();
        int val = Integer.valueOf(s);
        if (val > max || val < min)
            return null;
        queue.poll();
        TreeNode root = new TreeNode(val);
        root.left = deserialize(queue, min, val);
        root.right = deserialize(queue, val, max);
        return root;
    }
}