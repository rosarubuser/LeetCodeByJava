public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode ele = queue.poll();
            if (ele == null)
                sb.append("null,");
            else {
                sb.append(ele.val + ",");
                queue.offer(ele.left);
                queue.offer(ele.right);
            }
        }
        sb.setLength(sb.length() - 1);
        sb.append("]");
        // System.out.println(sb.toString());  // Testing
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // System.out.println(data);  // Testing
        StringBuilder sb = new StringBuilder(data);
        TreeNode root = null;
        Queue<TreeNode> queue = new LinkedList<>(); // store the pre-node to add leaves
        
        // find the root
        int i = 1;
        StringBuilder substringSB = new StringBuilder();
        for (; i <= sb.length() - 1; i++) {
            if (sb.charAt(i) != ',' && sb.charAt(i) != ']') {
                substringSB.append(sb.charAt(i));
            } else {
                String substring = new String(substringSB.toString());
                if (substring.equals("null")) {
                    return null;
                }
                else {
                    root = new TreeNode(Integer.parseInt(substring));
                    queue.offer(root);
                    break;
                }
            }
        }
        i++;    // escape ','
        
        substringSB = new StringBuilder();
        TreeNode node = queue.poll();
        int count = 0;  // to differentiate left & right (left 0, right 1)
        for (; i <= sb.length() - 1; i++) {
            if (sb.charAt(i) != ',' && sb.charAt(i) != ']') {
                substringSB.append(sb.charAt(i));
                // System.out.println(sb.charAt(i));  // Testing
            } else {
                String substring = substringSB.toString();
                // System.out.println(substring);  // Testing
                if (substring.equals("null")) { // cannot use '==' for objects
                    // System.out.println("enter1");  // Testing
                    if (count == 0) {
                        node.left = null;
                        count = 1;
                    } else {
                        node.right = null;
                        count = 0;
                        node = queue.poll();
                    }
                } else {
                    // System.out.println("enter2");  // Testing
                    if (count == 0) {
                        node.left = new TreeNode(Integer.parseInt(substring));
                        queue.offer(node.left);
                        count = 1;
                    } else {
                        node.right = new TreeNode(Integer.parseInt(substring));
                        count = 0;
                        queue.offer(node.right);
                        node = queue.poll();
                    }
                }
                substringSB = new StringBuilder();
            }
        }
        return root;
    }
}


public class Codec {
    private static final String spliter = ",";
    private static final String end = "X";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        treeToString(root, sb);
        return sb.toString();
    }
    
    private void treeToString(TreeNode root, StringBuilder sb) {
        if (root == null)
            sb.append(end).append(spliter);
        else {
            sb.append(root.val).append(spliter);
            treeToString(root.left, sb);
            treeToString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return list2Tree(nodes);
    }
    
    private TreeNode list2Tree(Deque<String> nodes) {
        String tmp = nodes.remove();
        if (tmp.equals(end)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(tmp));
            node.left = list2Tree(nodes);
            node.right = list2Tree(nodes);
            return node;
        }
    }
}

public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("n ");
                continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}