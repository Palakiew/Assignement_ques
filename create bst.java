class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BSTFromArray {

    
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

    
    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    
    public static void main(String[] args) {
        BSTFromArray tree = new BSTFromArray();
        int[] arr = {10, 5, 15, 3, 7, 12, 18};
        TreeNode root = tree.buildBST(arr);

        System.out.print("Inorder traversal of BST: ");
        tree.inorder(root);
    }
}
