package string;

import java.util.ArrayList;
import java.util.List;

/**
 *description:
 *author:       alex
 *createDate:   2020/7/19 10:42
 *version:      1.0.0
 */
public class MaxNumOfSubstrings {

    public List<String> maxNumOfSubstrings(String s) {
        List<String> res = new ArrayList<>();
        int index = 0;
        int len = s.length();
        while(index < len) {
            char ch = s.charAt(index);
            /*if ()*/
        }
        return res;
    }

    private boolean find(String s, int start, int end) {
        char ch = s.charAt(start);
        while(start < end) {
            if (s.charAt(start) != ch) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abbaccd";
        MaxNumOfSubstrings maxNumOfSubstrings = new MaxNumOfSubstrings();
        System.out.println(maxNumOfSubstrings.maxNumOfSubstrings(s));
    }
}
