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
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        preorderHelper(res, root);
        return res;
    }
    
    private void preorderHelper(List<Integer> res, Node root) {
        if (root == null) return;
        
        res.add(root.val);
        for (Node chil: root.children) {
            preorderHelper(res, chil);
        }
    }
}