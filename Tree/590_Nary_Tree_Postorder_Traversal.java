/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

// Recursion
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postorderHelper(res, root);
        return res;
    }
    
    private void postorderHelper(List<Integer> res, Node root) {
        if (root == null) return;
        for (Node child : root.children) {
            postorderHelper(res, child);
        }
        res.add(root.val);
    }
}