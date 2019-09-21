package tree.binartTree;

import java.util.Arrays;

/**
 * @description:
 * 已知
 * 前序遍历：GDAFEMHZ
 * 中序遍历:ADEFGHMZ
 * 求后序遍历
 * @author: alex
 * @create: 2019-09-21 08:53:31
 * @version: 1.0
 **/
public class CalculateSequence {

    public static void main(String[] args) {
        CalculateSequence calculateSequence = new CalculateSequence();
        char[] prefix = {'G', 'D', 'A', 'F', 'E', 'M', 'H', 'Z'};
        char[] infix = {'A', 'D', 'E', 'F', 'G', 'H', 'M', 'Z'};
        calculateSequence.getPostfixByPrefixAndInfix(prefix, infix);
    }

    private void getPostfixByPrefixAndInfix(char[] prefix, char[] infix) {
        if (prefix.length == 0 || infix.length == 0)
            return;
        int index = findIndex(prefix[0], infix);
        if (index != -1) {
            getPostfixByPrefixAndInfix(Arrays.copyOfRange(prefix,1, index + 1), Arrays.copyOfRange(infix, 0 , index ));
            getPostfixByPrefixAndInfix(Arrays.copyOfRange(prefix,index + 1, prefix.length), Arrays.copyOfRange(infix, index + 1, prefix.length));
        }
        System.out.print(infix[index]);
    }

    private int findIndex(char ch, char[] infix) {
        for (int i = 0; i < infix.length; i++)
            if (ch == infix[i])
                return i;
        return -1;
    }
}
