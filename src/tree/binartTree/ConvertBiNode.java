package tree.binartTree;

import java.util.ArrayList;
import java.util.List;

/**
 *description:
 * 面试题 17.12. BiNode
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求值的顺序保持不变，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 *
 * 返回转换后的单向链表的头节点。
 *
 * 注意：本题相对原题稍作改动
 *
 *
 *
 * 示例：
 *
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 * 提示：
 *
 * 节点数量不会超过 100000。
 *author:       alex
 *createDate:  2020/3/15 15:58
 *version:      1.0.0      
*/
public class ConvertBiNode {

    List<Integer> res = new ArrayList<>();
    public TreeNode convertBiNode1(TreeNode root) {
        midorder(root);
        if (res.size() < 2) {
            return root;
        }
        return convert();
    }

    private TreeNode convert() {
        TreeNode result = new TreeNode(res.get(0));
        TreeNode cur = result;
        int index = 1;
        int len = res.size();
        while(index < len) {
            cur.right = new TreeNode(res.get(index++));
            cur = cur.right;
        }
        return result;
    }

    private void midorder(TreeNode root) {
        if (root == null) {
            return;
        }
        midorder(root.left);
        res.add(root.val);
        midorder(root.right);
    }

    public TreeNode convertBiNode(TreeNode root) {
        TreeNode head = new TreeNode(-1);
        midConvert(root, head);
        return head.right;
    }

    private TreeNode midConvert(TreeNode root, TreeNode head) {
        if(root == null) {
            return head;
        }
        head = midConvert(root.left, head);
        root.left = null;
        head.right = root;
        head = midConvert(root.right, root);
        return head;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);;
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(5);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(6);
        treeNode.left.left.left = new TreeNode(0);
        ConvertBiNode convertBiNode = new ConvertBiNode();
        TreeNode res = convertBiNode.convertBiNode(treeNode);
        System.out.println(res.toString());
    }
}
