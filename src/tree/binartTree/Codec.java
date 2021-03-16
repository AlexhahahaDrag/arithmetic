package tree.binartTree;

import tree.binartTree.TreeNode;

import java.util.ArrayDeque;

/**
 *description:
 * 449. 序列化和反序列化二叉搜索树
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 *
 * 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 *
 * 编码的字符串应尽可能紧凑。
 *
 * 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 *author:       alex
 *createDate:   2020/6/10 22:01
 *version:      1.0.0
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = serial(root, new StringBuilder());
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private StringBuilder serial(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return sb;
        }
        serial(root.left, sb);
        serial(root.right, sb);
        sb.append(root.val + ",");
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) {
            return null;
        }
        String[] strs = data.split(",");
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        for (String str : strs) {
            nums.add(Integer.parseInt(str));
        }
        return deseial(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
    }

    private TreeNode deseial(Integer lower, Integer uppper, ArrayDeque<Integer> nums) {
        if (nums.isEmpty()) {
            return null;
        }
        int num = nums.getLast();
        if (num < lower || num > uppper) {
            return null;
        }
        nums.removeLast();
        TreeNode root = new TreeNode(num);
        root.right = deseial(num, uppper, nums);
        root.left = deseial(lower, num, nums);
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode treeNode = null;
        System.out.println(codec.serialize(treeNode));
        String str = codec.serialize(treeNode);
        TreeNode res = codec.deserialize(str);
        System.out.println();
    }
}
