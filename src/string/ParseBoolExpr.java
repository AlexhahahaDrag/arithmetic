package string;

import java.util.Stack;

/**
 *description:
 *
 *  解析布尔表达式 显示英文描述
 * 题目难度Hard
 * 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
 *
 * 有效的表达式需遵循以下约定：
 *
 * "t"，运算结果为 True
 * "f"，运算结果为 False
 * "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 * "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
 * "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 *
 *
 * 示例 1：
 *
 * 输入：expression = "!(f)"
 * 输出：true
 * 示例 2：
 *
 * 输入：expression = "|(f,t)"
 * 输出：true
 * 示例 3：
 *
 * 输入：expression = "&(t,f)"
 * 输出：false
 * 示例 4：
 *
 * 输入：expression = "|(&(t,f,t),!(t))"
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= expression.length <= 20000
 * expression[i] 由 {'(', ')', '&', '|', '!', 't', 'f', ','} 中的字符组成。
 * expression 是以上述形式给出的有效表达式，表示一个布尔值。
 *author:       alex
 *createDate:  2020/2/8 11:28
 *version:      1.0.0      
*/
public class ParseBoolExpr {
    /*private boolean parseBoolExpr(String expression) {
        char[] exp = expression.toCharArray();
        return parseBoolExprHelper(exp,0, exp.length - 1);
    }

    private boolean parseBoolExprHelper(char[] exp, int l, int r) {
        if (exp[l] == '(') {
            l++;
            r--;
        }
        char ch = exp[l];
        if (l == r)
            return exp[l] == 't';
        if (ch == '!') {
            l++;
            return !(parseBoolExprHelper(exp, l, r));
        }
        if (ch == '&') {

        }
    }*/

    Stack<Integer> stack = new Stack<>();
    private boolean parseBoolExpr(String expression) {
        char[] chars = expression.toCharArray();
        int index = 0;
        while(index < chars.length) {
            if (chars[index] == '!' || chars[index] == '&' || chars[index] == '|')
                stack.add(index);
             else if (chars[index] == ')')
                judge(chars, stack.pop(), index);
            index++;
        }
        return chars[chars.length - 1] == 't';
    }

    private void judge(char[] chars, int start, int end) {
        boolean flag = false;
        switch (chars[start]) {
            case '!' :
                for (int i = start; i < end; i++) {
                    if (chars[i] == '0')
                        continue;
                    if (chars[i] == 't')
                        flag = false;
                    else if (chars[i] == 'f')
                        flag = true;
                    chars[i] = '0';
                };
                chars[end] = flag ? 't' : 'f';
                break;
            case '&' :
                flag = true;
                for (int i = start; i <= end; i++) {
                    if (chars[i] == '0')
                        continue;
                    if (chars[i] == 'f')
                        flag = false;
                    chars[i] = '0';
                };
                chars[end] = flag ? 't' : 'f';
                break;
            case '|' :
                for (int i = start; i <= end; i++) {
                    if (chars[i] == '0')
                        continue;
                    if (chars[i] == 't')
                        flag = true;
                    chars[i] = '0';
                };
                chars[end] = flag ? 't' : 'f';
                break;
            default:
                return;
        }
    }

    public static void main(String[] args) {
        String str = "|(&(t,f,!(t),t),!(t),&(t,t))";
        ParseBoolExpr parseBoolExpr = new ParseBoolExpr();
        System.out.println(parseBoolExpr.parseBoolExpr(str));
    }
}
