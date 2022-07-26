package classes;

/**
 *description:
 * 732. 我的日程安排表 III
 * 当 k 个日程安排有一些时间上的交叉时（例如 k 个日程安排都在同一时间内），就会产生 k 次预订。
 *
 * 给你一些日程安排 [start, end) ，请你在每个日程安排添加后，返回一个整数 k ，表示所有先前日程安排会产生的最大 k 次预订。
 *
 * 实现一个 MyCalendarThree 类来存放你的日程安排，你可以一直添加新的日程安排。
 *
 * MyCalendarThree() 初始化对象。
 * int book(int start, int end) 返回一个整数 k ，表示日历中存在的 k 次预订的最大值。
 *
 *
 * 示例：
 *
 * 输入：
 * ["MyCalendarThree", "book", "book", "book", "book", "book", "book"]
 * [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
 * 输出：
 * [null, 1, 1, 2, 3, 3, 3]
 *
 * 解释：
 * MyCalendarThree myCalendarThree = new MyCalendarThree();
 * myCalendarThree.book(10, 20); // 返回 1 ，第一个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
 * myCalendarThree.book(50, 60); // 返回 1 ，第二个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
 * myCalendarThree.book(10, 40); // 返回 2 ，第三个日程安排 [10, 40) 与第一个日程安排相交，所以最大 k 次预订是 2 次预订。
 * myCalendarThree.book(5, 15); // 返回 3 ，剩下的日程安排的最大 k 次预订是 3 次预订。
 * myCalendarThree.book(5, 10); // 返回 3
 * myCalendarThree.book(25, 55); // 返回 3
 *
 *
 * 提示：
 *
 * 0 <= start < end <= 109
 * 每个测试用例，调用 book 函数最多不超过 400次
 *author:       alex
 *createDate:   2022/6/6 11:46
 *version:      1.0.0
 */
public class MyCalendarThree {

    private SegmentTree root;
    //    private int n = (int)1e9;
    private int n = (int)60;
    public MyCalendarThree() {
        root = new SegmentTree();
        root.left = 0;
        root.right = n;
    }

    public int book(int start, int end) {
        build(root, start, end, 0, n);
        return query(root, start, end, 0, n);
    }

    private int query(SegmentTree segmentTree, int start, int end, int ll, int rr) {
        if (start <= ll && end >= rr) {
            return segmentTree.sum;
        }
        int mid = ll + (rr - ll >> 1);
        int max = 0;
        if (start <= mid) {
            max = Math.max(max, query(segmentTree.lTree, start, end, ll, mid));
        }
        if (end > mid) {
            max = Math.max(max, query(segmentTree.rTree, start, end, mid + 1, rr));
        }
        return max;
    }

    private void build(SegmentTree segmentTree, int start, int end, int ll, int rr) {
        if (start <= ll && end >= rr) {
            segmentTree.sum ++;
            segmentTree.add ++;
            segmentTree.left = ll;
            segmentTree.right = rr;
            return;
        }
        pushDown(segmentTree);
        int mid = ll + (rr - ll >> 1);
        if (start <= mid) {
            build(segmentTree.lTree, start, end, ll, mid);
        }
        if (end > mid) {
            build(segmentTree.rTree, start, end, mid + 1, rr);
        }
        pushUp(segmentTree);
    }

    private void pushUp(SegmentTree segmentTree) {
        segmentTree.sum = Math.max(segmentTree.lTree.sum, segmentTree.rTree.sum);
    }

    private void pushDown(SegmentTree segmentTree) {
        int mid = segmentTree.left + (segmentTree.right - segmentTree.left >> 1);
        if (segmentTree.lTree == null) {
            segmentTree.lTree = new SegmentTree();
            segmentTree.lTree.left = segmentTree.left;
            segmentTree.lTree.right = mid;
        }
        if (segmentTree.rTree == null) {
            segmentTree.rTree = new SegmentTree();
            segmentTree.rTree.left = mid + 1;
            segmentTree.rTree.right = segmentTree.right;
        }
        if (segmentTree.add == 0) {
            return;
        }
        segmentTree.lTree.add = segmentTree.add;
        segmentTree.lTree.sum += segmentTree.add;
        segmentTree.rTree.add = segmentTree.add;
        segmentTree.rTree.sum += segmentTree.add;
        segmentTree.add = 0;
    }

    class SegmentTree {
        int left;
        int right;
        int sum;
        int add;
        SegmentTree lTree;
        SegmentTree rTree;
    }

    public static void main(String[] args) {
        MyCalendarThree myCalendarThree = new MyCalendarThree();
        System.out.println(myCalendarThree.book(10, 20));//1
        System.out.println(myCalendarThree.book(50, 60));//1
        System.out.println(myCalendarThree.book(10, 40));//2
        System.out.println(myCalendarThree.book(5, 15));//3
        System.out.println(myCalendarThree.book(5, 10));//2
        System.out.println(myCalendarThree.book(25, 55));//3


//        MyCalendarThree myCalendarThree = new MyCalendarThree();
//        System.out.println(myCalendarThree.book(26,35));//1
//        System.out.println(myCalendarThree.book(26,32));//2
//        System.out.println(myCalendarThree.book(25,32));//3
//        System.out.println(myCalendarThree.book(40,45));//1
//        System.out.println(myCalendarThree.book(48,50));//1
//        System.out.println(myCalendarThree.book(46,50));//2
//        System.out.println(myCalendarThree.book(11,18));//1
    }
}
