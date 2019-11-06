package string;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        String[] s = new String[]{null};
        System.out.println(s.length);
        System.out.println(generateParenthesis.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        char[] ch = new char[n << 1];
        for(int i = 0; i < n; i++)
            ch[i] = '(';
        for(int j = n; j < ch.length; j++)
            ch[j] = ')';
        List<String> list = new ArrayList<>();
        boolean flag = true;
        while(flag) {
            list.add(new String(ch));
            for(int i = 2; i < ch.length - 1; i++) {
                if(ch[i - 2] == '(' && ch[i] == ')'){
                    flag = true;
                    swap(ch, i - 1, i);
                    break;
                }
                flag = false;
            }
        }
        return list;
    }

    private void swap (char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
