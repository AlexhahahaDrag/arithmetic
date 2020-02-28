package tree.binartTree;

import java.util.*;

/**
 *description:
 * 501. 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *author:       alex
 *createDate:  2020/2/24 23:40
 *version:      1.0.0
 */
public class FindMode {
    Map<Integer, Integer> map = new HashMap();
    public int[] findMode1(TreeNode root) {
        find(root);
        int max = 0;
        for (Integer i : map.values())
            if (i > max)
                max = i;
        int[] arr = new int[map.size()];
        int size = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (max == entry.getValue())
                arr[size++] = entry.getKey();
        return Arrays.copyOf(arr, size);
    }

    private void find(TreeNode root) {
        if (root == null)
            return;
        find(root.left);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        find(root.right);
    }

    private List<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        find1(root);
        int len = list.size();
        int[] arr = new int[len];
        for(int i = 0; i < len; i++)
            arr[i] = list.get(i);
        return arr;
    }
    TreeNode pre = null;
    int index = 0;
    int max = 0;
    private void find1(TreeNode root) {
        if (root == null)
            return;
        find1(root.left);
        if (pre == null || pre.val == root.val) {
            index++;
        } else
            index = 1;
        if (index == max)
            list.add(root.val);
        else if (index > max) {
            list.clear();
            max = index;
            list.add(root.val);
        }
        pre = root;
        find1(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        FindMode findMode = new FindMode();
        int res[] = findMode.findMode(treeNode);
        for (int i : res)
            System.out.println(i + "  ");
    }
}
