package trees;

public class ConvertSortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return createTree(nums, 0, nums.length - 1);
    }

    public static TreeNode createTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createTree(nums, start, mid - 1);
        root.right = createTree(nums, mid + 1, end);
        return root;
    }

    // Method to print the tree to console
    public static void printTree(TreeNode root, String prefix, boolean isLeft) {
        if (root != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.val);
            printTree(root.left, prefix + (isLeft ? "│   " : "    "), true);
            printTree(root.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }

    static void printTree(TreeNode node, String prefix) {
        if (node == null)
            return;

        System.out.println(prefix + " + " + node.val);
        printTree(node.left, prefix + " ");
        printTree(node.right, prefix + " ");
    }

    public static void main(String[] args) {
        int[] arr = { -10, -3, 0, 5, 9 };

        TreeNode t1 = sortedArrayToBST(arr);
        printTree(t1, "", true);
        printTree(t1, "");
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
