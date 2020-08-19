package classes;

/**
 * @description:
 * 数据流的中位数
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 *
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xalff2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author:      alex
 * @createTime:  2020/8/19 17:06
 * @version:     1.0
 */
public class MedianFinder {

    private int[] res;

    private int size = 0;
    public MedianFinder() {
        res = new int[10];
    }

    public void addNum(int num) {
        if(size == res.length)
            changeMore();
        int i = size++;
        for(; i > 0; i--)
            if (res[i - 1] < num)
                res[i] = res[i - 1];
            else
                break;
         res[i] = num;
    }

    public double findMedian() {
        if ((size & 1) == 1)
            return res[size >> 1];
        else
            return (double)(res[size >> 1] + res[(size >> 1) - 1]) / 2;
    }

    private void changeMore() {
        int[] more = new int[res.length << 1];
        for (int i = 0; i < size; i++)
            more[i] = res[i];
        res = more;
    }

    public static void main(String[] args) {
//        MedianFinder medianFinder = new MedianFinder();
//        medianFinder.addNum(1);
//        medianFinder.addNum(2);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(3);
//        System.out.println(medianFinder.findMedian()); // -> 1.5
//        medianFinder.addNum(-4);
//        System.out.println(medianFinder.findMedian()); // -> 2
//        medianFinder.addNum(-5);
//        System.out.println(medianFinder.findMedian()); // -> 2*/
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian()); // -> 1.5
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian()); // -> 2
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian()); // -> 2
    }
}
