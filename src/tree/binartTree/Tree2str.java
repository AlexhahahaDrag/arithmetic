package tree.binartTree;

/**
 *description:
 *606. 根据二叉树创建字符串
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 *
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * 示例 1:
 *
 * 输入: 二叉树: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 *
 * 输出: "1(2(4))(3)"
 *
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 * 示例 2:
 *
 * 输入: 二叉树: [1,2,3,null,4]
 *        1
 *      /   \
 *     2     3
 *      \
 *       4
 *
 * 输出: "1(2()(4))(3)"
 *
 * 解释: 和第一个示例相似，
 * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 *author:       alex
 *createDate:   2020/6/10 21:10
 *version:      1.0.0
 */
public class Tree2str {

    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        getStr(t, sb);;
        return sb.toString();
    }

    private void getStr(TreeNode t, StringBuilder sb) {
        if (t != null) {
            sb.append(t.val);
            if(t.left != null || t.right != null) {
                sb.append("(");
                getStr(t.left, sb);
                sb.append(")");
                if (t.right != null) {
                    sb.append("(");
                    getStr(t.right, sb);
                    sb.append(")");
                }
            }
        }
    }

    private void getStr1(TreeNode t, StringBuilder sb) {
        if(t.left != null) {
            sb.append("(" + t.left.val);
            getStr(t.left, sb);
            sb.append(")");
            if (t.right != null) {
                sb.append("(" + t.right.val);
                getStr(t.right, sb);
                sb.append(")");
            }
        } else {
            if(t.right != null) {
                sb.append("()(" + t.right.val);
                getStr(t.right, sb);
                sb.append(")");
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        Tree2str tree2str = new Tree2str();
        System.out.println(tree2str.tree2str(root));
    }
}
