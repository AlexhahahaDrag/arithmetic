package math;

/**
 * Description:
 * 面试题 16.11. 跳水板
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 *
 * 返回的长度需要从小到大排列。
 *
 * 示例：
 *
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 * 提示：
 *
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 * Author:      alex
 * CreateDate:  2020/7/8 9:15
 * Version:     1.0
 *
*/
public class DivingBoard {

    public int[] divingBoard1(int shorter, int longer, int k) {
        if (k == 0)
            return new int[]{};
        int add = longer - shorter;
        if (add == 0)
            return new int[]{shorter * k};
        int[] res = new int[k + 1];
        int start = shorter * k;
        for (int i = 0; i <= k; i ++) {
            res[i] = start;
            start += add;
        }
        return res;
    }

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0)
            return new int[]{};
        if (longer == shorter)
            return new int[]{shorter * k};
        int[] res = new int[k + 1];
        for (int i = 0; i <= k; i ++)
            res[i] = shorter * (k - i) + longer * i;
        return res;
    }

    public static void main(String[] args) {
        int shorter = 2;
        int longer = 4;
        int k = 5;
        DivingBoard divingBoard = new DivingBoard();
        int[] res = divingBoard.divingBoard(shorter, longer, k);
        for(int i : res)
            System.out.print(i + "  ");
    }
}
