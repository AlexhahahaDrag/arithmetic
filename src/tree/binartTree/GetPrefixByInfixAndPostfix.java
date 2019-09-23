package tree.binartTree;

import java.util.Arrays;

/**
 * @Description:
 * @Author:     alex
 * @CreateDate: 2019/9/23 12:32
 * @Version:    1.0
 *
*/
public class GetPrefixByInfixAndPostfix {

    public static void main(String[] args) {
        GetPrefixByInfixAndPostfix getPrefixByInfixAndPostfix = new GetPrefixByInfixAndPostfix();
        char[] infix = {'A', 'D', 'E', 'F', 'G', 'H', 'M', 'Z'};
        char[] postfix = {'A', 'E', 'F', 'D', 'H', 'Z', 'M', 'G'};
        getPrefixByInfixAndPostfix.getPrefixAndInfixAndPostfix(infix, postfix);
    }

    private void getPrefixAndInfixAndPostfix(char[] infix, char[] postfix) {
        for (int i = 0; i < infix.length; i++) {
            if (infix[i] == postfix[postfix.length - 1]) {
                System.out.print(infix[i] + " ");
                getPrefixAndInfixAndPostfix(Arrays.copyOfRange(infix, 0, i), Arrays.copyOfRange(postfix, 0, i));
                getPrefixAndInfixAndPostfix(Arrays.copyOfRange(infix, i + 1, infix.length), Arrays.copyOfRange(postfix, i, postfix.length - 1));
            }
        }
    }
}
