class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BSTValidator {

   
    private TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);
        return root;
    }

    
    public TreeNode buildBST(int[] nums) {
        TreeNode root = null;
        for (int num : nums) {
            root = insert(root, num);
        }
        return root;
    }

    
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isValidBSTHelper(node.left, min, node.val) &&
               isValidBSTHelper(node.right, node.val, max);
    }

   
    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

 
    public static void main(String[] args) {
        BSTValidator tree = new BSTValidator();

        int[] arr = {10, 5, 15, 3, 7, 12, 18};
        TreeNode root = tree.buildBST(arr);

        System.out.print("Inorder traversal: ");
        tree.inorder(root);
        System.out.println();

        System.out.println("Is valid BST? " + tree.isValidBST(root));
    }
}
