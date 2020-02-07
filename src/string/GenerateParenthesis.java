package string;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        char[] ch = new char[n << 1];
        List<String> list = new ArrayList<>();
        dfs(list, ch,0, 0, 0, n);
        return list;
    }

    private void dfs(List<String> list, char[] ch, int index, int left, int right, int n) {
        if (left + right == (n << 1)) {
            list.add(new String(ch));
            return;
        }
        if (left < n) {
            ch[index] = '(';
            dfs(list, ch, index + 1, left + 1, right, n);
        }
        if (left > right) {
            ch[index] = ')';
            dfs(list, ch, index + 1, left, right + 1, n);
        }
    }

    public List<String> generateParenthesis2(int n) {
        char[] ch = new char[n << 1];
        List<String> list = new ArrayList<>();
        getList(list, 0, ch, 0, 0);
        return list;
    }

    private void getList(List<String> list, int index, char[] ch, int left, int right) {
        if (left > (ch.length >> 1) || right > left)
            return;
        if (index == ch.length) {
            list.add(new String(ch));
            return;
        }
        for (int i = '('; i <= ')'; i++) {
            ch[index] = (char)i;
            if (i == '(')
                left++;
            else
                right++;
            getList(list, index + 1, ch, left, right);
            if (i == '(')
                left--;
            else
                right--;
        }
    }
}
