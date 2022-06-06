package tree.binartTree;

public class DeleteNode {

//    private TreeNode min = null;
//    public TreeNode deleteNode(TreeNode root, int key) {
//        if (root == null) {
//            return null;
//        }
//        if (root.val > key) {
//            root.left = deleteNode(root.left, key);
//        } else if (root.val < key) {
//            root.right = deleteNode(root.right, key);
//        } else {
//            root.right = getRight(root.right);
//            //如果右侧没有最小值，代表右侧为空
//            if(min != null) {
//                root.val = min.val;
//            } else {
//                return root.left;
//            }
//        }
//        return root;
//    }
//
//    private TreeNode getRight(TreeNode node) {
//        if(node == null) {
//            return null;
//        }
//        if (node.left == null) {
//            min = node;
//            return node.right;
//        }
//        node.left = getRight(node.left);
//        return node;
//    }


    public int rightmin(TreeNode root) {
        root = root.right;
        while (root.left != null)
            root = root.left;
        return root.val;
    }

    public int leftmax(TreeNode root) {
        root = root.left;
        while (root.right != null)
            root = root.right;
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (key > root.val)
            root.right = deleteNode(root.right, key);
        else if (key < root.val)
            root.left = deleteNode(root.left, key);
        else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left != null) {
                root.val = leftmax(root);
                root.left = deleteNode(root.left, root.val);


            } else {
                root.val = rightmin(root);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }
}
