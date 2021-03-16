package math;

/**
 * Description:
 * 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 *
 *    卡特兰数
 *    h(n) = (4 * n - 2) * h(n - 1);
 *    h(n) = 1 / (n + 1)C(2n, n)
 *    用于二叉搜索树生成数， 弹栈可能性等
 * Author:      alex
 * CreateDate:  2020/7/15 9:37
 * Version:     1.0
 *
*/
public class NumTrees {

    public int numTrees(int n) {
        long res = 1;
        long index = 1;
        while(++index <= n) {
            res = res * (4 * index - 2) / (index + 1);
        }
        return (int)res;
    }

    public static void main(String[] args) {
        int n = 19;
        NumTrees numTrees = new NumTrees();
        System.out.println(numTrees.numTrees(n));
    }
}
