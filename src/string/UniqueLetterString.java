package string;

import java.util.*;

public class UniqueLetterString {
    public static void main(String[] args) {
        UniqueLetterString uniqueLetterString = new UniqueLetterString();;
        System.out.println(uniqueLetterString.uniqueLetterString("ABA"));
    }

    public int uniqueLetterString(String S) {
        List<String> set = new LinkedList<>();
        List<String> list = new ArrayList<>();
        int subLen = 1;
        int len = S.length();
        int start;
        String ss;
        while (subLen <= len) {
            start = 0;
            while (start + subLen <= len) {
                ss = S.substring(start, start + subLen);
                set.add(ss);
                start++;
            }
            subLen++;
        }
        int sum = 0;
        for (String st : set) {
            sum += findUnique(st);
        }
        return sum;
    }
    private int findUnique(String ss) {
        char[] str = ss.toCharArray();
        int[] flag = new int[60];
        int count =0;

        for (int i = 0; i < str.length; i++){
            int num = str[i]-'a';
            flag[str[i]-'A']++;
        }

        for (int i = 0; i < flag.length; i++) {
            if (flag[i]==1) {
                count++;
            }
        }
        return count;
    }
}
