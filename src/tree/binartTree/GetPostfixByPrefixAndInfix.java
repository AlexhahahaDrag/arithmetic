package tree.binartTree;

import java.util.Arrays;

/**
 * @description:
 * 已知
 * 前序遍历：GDAFEMHZ
 * 中序遍历:ADEFGHMZ
 * 求后序遍历
 *
 * 已知前序遍历为{1,2,4,7,3,5,6,8}，中序遍历为{4,7,2,1,5,3,8,6}，它的二叉树是怎么样的？
 * @author: alex
 * @create: 2019-09-21 08:53:31
 * @version: 1.0
 **/
public class GetPostfixByPrefixAndInfix {

    public static void main(String[] args) {
        GetPostfixByPrefixAndInfix calculateSequence = new GetPostfixByPrefixAndInfix();
        char[] prefix = {'G', 'D', 'A', 'F', 'E', 'M', 'H', 'Z'};
        char[] infix = {'A', 'D', 'E', 'F', 'G', 'H', 'M', 'Z'};
        int[] prefixes = {1,2,4,7,3,5,6,8};
        int[] infixes = {4,7,2,1,5,3,8,6};
        TreeNode treeNode = calculateSequence.getTreeNodeByPrefixAndInfix(prefixes, infixes);
        System.out.println(treeNode);
        calculateSequence.getPostfixByPrefixAndInfix(prefix, infix);
    }

    private void getPostfixByPrefixAndInfix(char[] prefix, char[] infix) {
        if (prefix.length == 0 || infix.length == 0) {
            return;
        }
        int index = findIndex(prefix[0], infix);
        if (index != -1) {
            getPostfixByPrefixAndInfix(Arrays.copyOfRange(prefix,1, index + 1), Arrays.copyOfRange(infix, 0 , index ));
            getPostfixByPrefixAndInfix(Arrays.copyOfRange(prefix,index + 1, prefix.length), Arrays.copyOfRange(infix, index + 1, prefix.length));
        }
        System.out.print(infix[index]);
    }

    private int findIndex(char ch, char[] infix) {
        for (int i = 0; i < infix.length; i++) {
            if (ch == infix[i]) {
                return i;
            }
        }
        return -1;
    }

    private TreeNode getTreeNodeByPrefixAndInfix(int[] prefix, int[] infix) {
        TreeNode treeNode;
        if (prefix.length == 0 || infix.length == 0) {
            return null;
        }
        treeNode = new TreeNode(prefix[0]);
        int index = findIndex(prefix[0], infix);
        if (index != -1) {
            treeNode.left = getTreeNodeByPrefixAndInfix(Arrays.copyOfRange(prefix,1, index + 1), Arrays.copyOfRange(infix, 0 , index ));
            treeNode.right = getTreeNodeByPrefixAndInfix(Arrays.copyOfRange(prefix,index + 1, prefix.length), Arrays.copyOfRange(infix, index + 1, prefix.length));
        }
        return treeNode;
    }

    private int findIndex(int ch, int[] infix) {
        for (int i = 0; i < infix.length; i++) {
            if (ch == infix[i]) {
                return i;
            }
        }
        return -1;
    }
}
