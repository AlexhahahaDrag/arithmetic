package tree.binartTree;

import java.util.*;

/**
 * description:
 * <p>
 * 2385. 感染二叉树需要的总时间
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发。
 * <p>
 * 每分钟，如果节点满足以下全部条件，就会被感染：
 * <p>
 * 节点此前还没有感染。
 * 节点与一个已感染节点相邻。
 * 返回感染整棵树需要的分钟数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,5,3,null,4,10,6,9,2], start = 3
 * 输出：4
 * 解释：节点按以下过程被感染：
 * - 第 0 分钟：节点 3
 * - 第 1 分钟：节点 1、10、6
 * - 第 2 分钟：节点5
 * - 第 3 分钟：节点 4
 * - 第 4 分钟：节点 9 和 2
 * 感染整棵树需要 4 分钟，所以返回 4 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1], start = 1
 * 输出：0
 * 解释：第 0 分钟，树中唯一一个节点处于感染状态，返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [1, 105] 内
 * 1 <= Node.val <= 105
 * 每个节点的值 互不相同
 * 树中必定存在值为 start 的节点
 * <p>
 * author:       majf
 * createDate:   2024/4/24 12:23
 * version:      1.0.0
 */
public class AmountOfTime {

    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        dfs(root, map);
        Set<Integer> visited = new HashSet<>();
        List<Integer> next = new ArrayList<>();
        next.add(start);
        visited.add(start);
        return getMinutes(next, map, visited);
    }

    private int getMinutes(List<Integer> cur, Map<Integer, List<Integer>> map, Set<Integer> visited) {
        if (cur.isEmpty()) {
            return 0;
        }
        List<Integer> next = new ArrayList<>();
        for (int i : cur) {
            List<Integer> list = map.get(i);
            if (list == null) {
                continue;
            }
            for (int n : list) {
                if (visited.contains(n)) {
                    continue;
                }
                next.add(n);
                visited.add(n);
            }
        }
        return next.isEmpty() ? 0 : 1 + getMinutes(next, map, visited);
    }

    private void dfs(TreeNode node, Map<Integer, List<Integer>> map) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            map.computeIfAbsent(node.left.val, k -> new ArrayList<>()).add(node.val);
            map.computeIfAbsent(node.val, k -> new ArrayList<>()).add(node.left.val);
            dfs(node.left, map);
        }
        if (node.right != null) {
            map.computeIfAbsent(node.right.val, k -> new ArrayList<>()).add(node.val);
            map.computeIfAbsent(node.val, k -> new ArrayList<>()).add(node.right.val);
            dfs(node.right, map);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 5, 3, null, 4, 10, 6, 9, 2};
        TreeNode root = TreeNode.getTreeNodeByArr(arr);
        int start = 3;
        AmountOfTime amountOfTime = new AmountOfTime();
        System.out.println(amountOfTime.amountOfTime(root, start));
    }
}
