class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            if (root.val >= low && root.val <= high)
                return root;
            else
                return null;
        }
        
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        
        if (root.val >= low && root.val <= high) {
            return root;
        } else if (root.val > high) {
            return root.left;
        } else {
            return root.right;
        }
    }
}

class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val > high) return trimBST(root.left, low, high);
        if (root.val < low) return trimBST(root.right, low, high);
        
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}

// Iteration
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        
        while (root.val < low || root.val > high) {
            if (root.val < low)
                root = root.right;
            if (root.val > high)
                root = root.left;
        }
        
        // trim for the left side of BST
        TreeNode dummy = root;
        while (dummy != null) {
            while (dummy.left != null && dummy.left.val < low) {
                dummy.left = dummy.left.right;
            }
            dummy = dummy.left;
        }
        
        dummy = root;
        while (dummy != null) {
            while (dummy.right != null && dummy.right.val > high) {
                dummy.right = dummy.right.left;
            }
            dummy = dummy.right;
        }
        
        return root;
    }
}