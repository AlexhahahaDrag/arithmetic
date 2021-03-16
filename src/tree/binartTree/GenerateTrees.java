package tree.binartTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * 95. 不同的二叉搜索树 II
 * 难度
 * 中等
 *
 * 513
 *
 * 收藏
 *
 * 分享
 *
 * 切换为英文
 *
 * 关注
 *
 * 反馈
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 *
 * 示例：
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 提示：
 * 0 <= n <= 8
 * @author:      alex
 * @createTime:  2020/7/21 12:24
 * @version:     1.0
 */
public class GenerateTrees {

    public List<TreeNode> generateTrees(int n) {
        if (n < 0) {
            return null;
        } else if (n == 0) {
            return new ArrayList<>();
        }
        return generateTree(1, n);
    }

    private List<TreeNode> generateTree(int start, int n) {
        List<TreeNode> res = new ArrayList<>();
        if (start > n) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= n; i++) {
            List<TreeNode> left = generateTree(start, i - 1);
            List<TreeNode> right = generateTree(i + 1, n);
            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        GenerateTrees generateTrees = new GenerateTrees();
        System.out.println(generateTrees.generateTrees(0));
    }
}
