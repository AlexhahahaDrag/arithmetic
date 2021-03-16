package tree.binartTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * @Author:     alex
 * @CreateDate: 2019/11/28 17:13
 * @Version:    1.0
 *
 */
public class GeneratorTrees {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n < 0) {
            return null;
        } else if (n == 0) {
            return result;
        }
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int n) {
        List<TreeNode> result = new ArrayList<>();
        if (start > n) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= n; i++) {
            List<TreeNode> left = generate(start, i - 1);
            List<TreeNode> right = generate(i + 1, n);
            for(int j = 0; j < left.size(); j++) {
                for(int k = 0; k < right.size(); k++){
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    result.add(root);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GeneratorTrees generatorTrees = new GeneratorTrees();
        List<TreeNode> list = generatorTrees.generateTrees(0);
        System.out.println(list);
    }
}
