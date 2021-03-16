package string;

import java.util.*;

/**
 *description:  
 *author:       alex
 *createDate:   2020/10/18 10:40
 *version:      1.0.0
 */
public class FindLexSmallestString {
    private Set<String> map;
    private char[] min;
    public String findLexSmallestString(String s, int a, int b) {
        map = new HashSet<>();
        min = s.toCharArray();
        findMin(s.toCharArray(), a, b);
        return new String(min);
    }

    private void findMin(char[] s, int a, int b) {
        if (map.contains(new String(s))) {
            return;
        }
        char[] as = Arrays.copyOf(s, s.length);
        for (int i = 1; i < s.length; i += 2) {
            as[i] = (char)((as[i] - '0' + a) % 10 + '0');
        }
        char[] bs = Arrays.copyOf(s, s.length);
        swap(bs, 0, s.length - b - 1);
        swap(bs, s.length - b, s.length - 1);
        swap(bs, 0, s.length - 1);
        map.add(new String(s));
        if (min(min, as)) {
            min = Arrays.copyOf(as, as.length);
        }
        if (min(min, bs)) {
            min = Arrays.copyOf(bs, bs.length);
        }
        findMin(as, a, b);
        findMin(bs, a, b);
    }

    private void swap(char[] ch, int from, int end) {
        while(from < end) {
            char temp = ch[from];
            ch[from++] = ch[end];
            ch[end--] = temp;
        }
    }

    private boolean min (char[] a, char[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] > b[i]) {
                return true;
            } else if (a[i] < b[i]) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "5525";
        int a = 9;
        int b = 2;
        //s = "5525", a = 9, b = 2
        FindLexSmallestString findLexSmallestString = new FindLexSmallestString();
        System.out.println(findLexSmallestString.findLexSmallestString(s, a, b));
    }
}
