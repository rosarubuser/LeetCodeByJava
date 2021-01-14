// DFS

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (allSubZeros(root))
            return null;
        else
            return root;
    }
    
    private boolean allSubZeros(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) {
            if (root.val == 0)
                return true;
            else
                return false;
        }
        
        boolean left0 = allSubZeros(root.left);
        boolean right0 = allSubZeros(root.right);
        if (left0) {
            root.left = null;
        }
        if (right0) {
            root.right = null;
        }
        if (left0 && right0 && root.val == 0)
            return true;
        else
            return false;
    }
}


// no need of helper
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        
        if (root.left == null && root.right == null && root.val == 0)
            return null;
        
        return root;
    }
}
