package string;

/**
 *description:
 * 面试题 01.05. 一次编辑
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * 示例 1:
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *  
 *
 * 示例 2:
 *
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/one-away-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *author:       alex
 *createDate:  2020/2/17 19:58
 *version:      1.0.0      
*/
public class OneEditAway {

    public boolean oneEditAway(String first, String second) {
        int flen = first.length();
        int slen = second.length();
        int one = flen - slen;
        if (one < -1 || one > 1) {
            return false;
        }
        int fi = 0;
        int se = 0;
        boolean flag = true;
        while(fi < flen && se < slen) {
            if(first.charAt(fi) != second.charAt(se)) {
                if (flag) {
                    flag = false;
                    if (one == 1) {
                        se--;
                    } else if (one == -1) {
                        fi--;
                    }
                }else {
                    return false;
                }
            }
            fi++;
            se++;
        }
        return true;
    }

    public static void main(String[] args) {
        OneEditAway oneEditAway = new OneEditAway();
        System.out.println(oneEditAway.oneEditAway("pales", "pals"));
    }
}
