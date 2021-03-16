package math;

import java.util.LinkedList;
import java.util.List;

/**
 *description:
 * 约瑟夫问题（有时也称为约瑟夫斯置换，是一个出现在计算机科学和数学中的问题。在计算机编程的算法中，类似问题又称为约瑟夫环。又称“丢手绢问题”.）
 *
 *
 *
 *
 * 面试题62. 圆圈中最后剩下的数字
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 *
 *
 * 限制：
 *
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 *
 * 约瑟夫环问题
 *author:       alex
 *createDate:  2020/2/28 20:53
 *version:      1.0.0      
 */
public class LastRemaining {

    public int lastRemaining1(int n, int m) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while(list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }

    public int lastRemaining3(int n, int m) {
        boolean[] map = new boolean[n];
        int len = n;
        int index = 0;
        int count = 0;
        while(n > 1) {
            int move = m % n == 0 ? m : m % n;
            if (!map[index]) {
                count++;
                if (count == move) {
                    map[index] = true;
                    count = 0;
                    n--;
                }
            }
            index = ++index == len ? 0 : index;
        }
        for (int i = 0; i < len; i++) {
            if (map[i] == false) {
                return i;
            }
        }
        return -1;
    }

    public int lastRemaining(int n, int m) {
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }

        return last;
    }

    public int lastRemaining2(int n, int m) {
        if(n == 1) {
            return 0;
        } else {
            return (lastRemaining2(n -1, m) + m) % n;
        }
    }

    public static void main(String[] args) {
        LastRemaining lastRemaining = new LastRemaining();
        System.out.println(lastRemaining.lastRemaining(10,17));
    }
}
