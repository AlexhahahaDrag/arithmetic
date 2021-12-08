package tree.binartTree;

/**
 *description:
 * 2096. 从二叉树一个节点到另一个节点每一步的方向
 * 给你一棵 二叉树 的根节点 root ，这棵二叉树总共有 n 个节点。每个节点的值为 1 到 n 中的一个整数，且互不相同。给你一个整数 startValue ，表示起点节点 s 的值，和另一个不同的整数 destValue ，表示终点节点 t 的值。
 *
 * 请找到从节点 s 到节点 t 的 最短路径 ，并以字符串的形式返回每一步的方向。每一步用 大写 字母 'L' ，'R' 和 'U' 分别表示一种方向：
 *
 * 'L' 表示从一个节点前往它的 左孩子 节点。
 * 'R' 表示从一个节点前往它的 右孩子 节点。
 * 'U' 表示从一个节点前往它的 父 节点。
 * 请你返回从 s 到 t 最短路径 每一步的方向。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
 * 输出："UURL"
 * 解释：最短路径为：3 → 1 → 5 → 2 → 6 。
 * 示例 2：
 *
 *
 *
 * 输入：root = [2,1], startValue = 2, destValue = 1
 * 输出："L"
 * 解释：最短路径为：2 → 1 。
 *
 *
 * 提示：
 *
 * 树中节点数目为 n 。
 * 2 <= n <= 105
 * 1 <= Node.val <= n
 * 树中所有节点的值 互不相同 。
 * 1 <= startValue, destValue <= n
 * startValue != destValue
 *author:       alex
 *createDate:   2021/12/8 17:31
 *version:      1.0.0
 */
public class GetDirections {

    StringBuilder res = new StringBuilder();
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode common = getCommon(root, startValue, destValue);
        int uNum = dfsStart(common, startValue);
        while(uNum-- > 0) {
            res.append("U");
        }
        dfs(common, destValue, new StringBuilder());
        return res.toString();
    }

    private int dfsStart(TreeNode node, int s) {
        if (node == null) {
            return 10000;
        }
        if (node.val == s) {
            return 0;
        }
        return Math.min(dfsStart(node.left, s), dfsStart(node.right, s)) + 1;
    }

    private void dfs(TreeNode node, int s, StringBuilder sb) {
        if (node == null) {
            return;
        }
        if (node.val == s) {
            res.append(sb);
            return;
        }
        dfs(node.left, s, sb.append("L"));
        sb.deleteCharAt(sb.length() - 1);
        dfs(node.right, s, sb.append("R"));
        sb.deleteCharAt(sb.length() - 1);
    }

    private TreeNode getCommon(TreeNode node, int s, int d) {
        if (node == null || node.val == s || node.val == d) {
            return node;
        }
        TreeNode left = getCommon(node.left, s, d);
        TreeNode right = getCommon(node.right, s, d);
        if (left != null && right != null) {
            return node;
        }
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        Integer[] arr = {5,1,2,3,null,6,4};
        int startValue = 3;
        int destValue = 6;
//        Integer[] arr = {2, 1};
//        int startValue = 2;
//        int destValue = 1;
        TreeNode root = TreeNode.getTreeNodeByArr(arr);
        GetDirections getDirections = new GetDirections();
        System.out.println(getDirections.getDirections(root, startValue, destValue));
    }
}
