package tree.binartTree;

/**
 *description:
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *author:       alex
 *createDate:  2020/3/24 20:55
 *version:      1.0.0      
 */
public class BuildTree {

    private int in, po;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        in = inorder.length - 1;
        po = postorder.length - 1;
        return build(inorder, postorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] inorder, int[] postorder, int curVal) {
        if (po < 0) {
            return null;
        }
        if(curVal == inorder[in]) {
            in--;
            return null;
        }
        int val = postorder[po--];
        TreeNode root = new TreeNode(val);
        root.right = build(inorder, postorder, val);
        root.left = build(inorder, postorder, curVal);
        return root;
    }


    int index = 0;
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        index = inorder.length - 1;
        return buildTree(inorder, postorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int from, int to) {
        if (from >= to) {
            return null;
        }
        int val = postorder[index--];
        TreeNode treeNode = new TreeNode(val);
        int cur = from;
        for (int i = 0; i < inorder.length; i++) {
            if (val == inorder[i]) {
                cur = i;
            }
        }
        treeNode.right = buildTree(inorder, postorder, cur + 1, to);
        treeNode.left = buildTree(inorder, postorder, from, cur);
        return treeNode;
    }

    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        return build(inorder, 0, inorder.length - 1, postorder);
    }

    private TreeNode build(int[] inorder, int from, int end, int[] postorder) {
        if (index == -1 || from > end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[index]);
        int in = from;
        for(; in <= end; in++) {
            if(inorder[in] == postorder[index]) {
                index--;
                break;
            }
        }
        root.right = build(inorder, in + 1, end, postorder);
        root.left = build(inorder, from, in - 1, postorder);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        BuildTree buildTree = new BuildTree();
        TreeNode root = buildTree.buildTree(inorder, postorder);
        System.out.println(root.toString());
    }
}
