class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pathP = new LinkedList<>();
        LinkedList<TreeNode> pathQ = new LinkedList<>();
        TreeNode res = root;
        boolean dummy = findPath(root, p, pathP) && findPath(root, q, pathQ);
        for (int i = 0; i < Math.min(pathP.size(), pathQ.size()); i++ ) {
            if (pathP.get(i) == pathQ.get(i)) {
                res = pathP.get(i);
            } else {
                break;
            }
        }
        return res;
    }
    
    private boolean findPath(TreeNode root, TreeNode target, LinkedList<TreeNode> path) {
        if (root == null)
            return false;
        if (root == target) { 
            path.addFirst(root);
            return true;
        }
        if (findPath(root.left, target, path) || findPath(root.right, target, path)) {
            path.addFirst(root);
            return true;
        }
        return false;
    }
}


class Solution {
    TreeNode res = null;    // here res must be a overall variable
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestorHelper(root, p, q);
        return res;
    }
    
    private boolean lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        int count = 0;
        
        if (root == null)
            return false;
        // System.out.println("current node is " + root.val);
        if (root == p || root == q)
            count++;
        
        if (lowestCommonAncestorHelper(root.left, p, q))
            count++;
        if (lowestCommonAncestorHelper(root.right, p, q))
            count++;
        // System.out.println("current count is " + count);
        if (count == 2)
            res = root;
        // System.out.println("current res is " + res);
        return count > 0;
    }
}