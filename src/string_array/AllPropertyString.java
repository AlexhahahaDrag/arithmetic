package string_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * 给定一个字符串，求出所有可能
 * Author:      alex
 * CreateDate:  2020/1/9 14:57
 * Version:     1.0
 *
*/
public class AllPropertyString {

    List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        AllPropertyString allPropertyString = new AllPropertyString();
        String str = "kjhkheuriugf";
        char[] ches = str.toCharArray();
        allPropertyString.sort(ches, 0 , ches.length);
        System.out.println(allPropertyString.getAllProperty(ches));
    }
    public List<String> getAllProperty(char[] strs) {
        list.add(new String(strs));
        getAllProperty11(strs);
        return list;
    }


    public void getAllProperty11(char[] strs) {

        int len = strs.length - 1;
        int index = strs.length - 1;
        int st = index;
        while(st >= 0) {
            while(index > 0 && strs[st] <= strs[index - 1])
                index--;
            if (index < 0)
                st--;
            else {
                swap(strs, index, st);
                sort(strs, index + 1, len);
                list.add(new String(strs));
                getAllProperty11(strs);
            }

        }
    }

    private void swap(char[] strs, int st, int ss) {
        char temp = strs[st];
        strs[st] = strs[ss];
        strs[ss] = temp;
    }

    private void sort(char[] strs, int start, int end) {
        Arrays.sort(strs, start, end);
    }
}
