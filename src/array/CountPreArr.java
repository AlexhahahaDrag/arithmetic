package array;

import java.util.Arrays;

/**
 * @Description:
 * 根据上排给出的十个数，在其下排填出对应的十个数，要求下排每个数都是先前上排那十个数在下排出现的次数。
 *
 * 上排的十个数如下：
 * 0,1,2,3,4,5,6,7,8,9
 *
 * 答案是：
 *
 * 6,2,1,0,0,0,1,0,0,0
 * @Author:     alex
 * @CreateDate: 2019/6/28 10:51
 * @Version:    1.0
 *
*/
public class CountPreArr {
    public static void main(String[] args) {
        int[] pre = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        CountPreArr countPreArr = new CountPreArr();
        System.out.println(Arrays.toString(countPreArr.findLastArr(pre)));
    }
    private int[] findLastArr(int[] pre) {
        boolean isChange = true;
        int[] results = new int[pre.length];
        int num;
        while (isChange) {
            isChange = false;
            for (int i = 0; i < pre.length; i++) {
                num = 0;
                for (int j = 0; j < pre.length; j++) {
                    if (results[j] == pre[i]) {
                        num++;
                    }
                }
                if (num != results[i]) {
                    isChange = true;
                    results[i] = num;
                }
            }
        }
        return results;
    }
}
