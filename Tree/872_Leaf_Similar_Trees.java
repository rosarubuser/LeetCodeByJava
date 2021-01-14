// DFS
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leaf1 = new ArrayList<>(), leaf2 = new ArrayList<>();
        findLeaves(root1, leaf1);
        findLeaves(root2, leaf2);
        if (leaf1.size() != leaf2.size()) {
            return false;
        }    
        for (int i = 0; i < leaf1.size(); i += 1) {
            if (leaf1.get(i) != leaf2.get(i))
                return false;
        }
        return true;
    }
    
    private void findLeaves(TreeNode root, ArrayList<Integer> leaf) {
        if (root.left == null && root.right == null) {
            leaf.add(root.val);
            return;
        }
        if (root.left != null)
            findLeaves(root.left, leaf);
        if (root.right != null)
            findLeaves(root.right, leaf);
    }
}

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leaf1 = new ArrayList<>(), leaf2 = new ArrayList<>();
        findLeaves(root1, leaf1);
        findLeaves(root2, leaf2);
        return leaf1.equals(leaf2);
    }
    
    private void findLeaves(TreeNode root, ArrayList<Integer> leaf) {
        if (root.left == null && root.right == null) {
            leaf.add(root.val);
            return;
        }
        if (root.left != null)
            findLeaves(root.left, leaf);
        if (root.right != null)
            findLeaves(root.right, leaf);
    }
}

// DFS preorder
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
        s1.push(root1); s2.push(root2);
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (dfs(s1) != dfs(s2)) return false;
        }
        return s1.isEmpty() && s2.isEmpty();
    }
    
    // here: everytime encounter an end node, return leaf value
    private int dfs(Stack<TreeNode> stack) {
        while (true) {
            TreeNode node = stack.pop();
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
            if (node.left == null && node.right == null)
                return node.val;
        }
    }
}
