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

// Iteration
class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        
        if (root == null) return res;
        
        stack.add(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            res.addFirst(curr.val);
            for (Node child : curr.children)
                stack.add(child);
        }
        return res;
    }
}