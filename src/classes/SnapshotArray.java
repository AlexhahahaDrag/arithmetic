package classes;

import java.util.*;

/**
 * description:
 * 1146. 快照数组
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 实现支持下列接口的「快照数组」- SnapshotArray：
 * <p>
 * SnapshotArray(int length) - 初始化一个与指定长度相等的 类数组 的数据结构。初始时，每个元素都等于 0。
 * void set(index, val) - 会将指定索引 index 处的元素设置为 val。
 * int snap() - 获取该数组的快照，并返回快照的编号 snap_id（快照号是调用 snap() 的总次数减去 1）。
 * int get(index, snap_id) - 根据指定的 snap_id 选择快照，并返回该快照指定索引 index 的值。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：["SnapshotArray","set","snap","set","get"]
 * [[3],[0,5],[],[0,6],[0,0]]
 * 输出：[null,null,0,null,5]
 * 解释：
 * SnapshotArray snapshotArr = new SnapshotArray(3); // 初始化一个长度为 3 的快照数组
 * snapshotArr.set(0,5);  // 令 array[0] = 5
 * snapshotArr.snap();  // 获取快照，返回 snap_id = 0
 * snapshotArr.set(0,6);
 * snapshotArr.get(0,0);  // 获取 snap_id = 0 的快照中 array[0] 的值，返回 5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= length <= 50000
 * 题目最多进行50000 次set，snap，和 get的调用 。
 * 0 <= index < length
 * 0 <= snap_id < 我们调用 snap() 的总次数
 * 0 <= val <= 10^9
 * author:       majf
 * createDate:   2024/4/26 16:51
 * version:      1.0.0
 */
public class SnapshotArray {

    private List<int[]>[] data;

    private int snap = 0;

    public SnapshotArray(int length) {
        data = new List[length];
        for (int i = 0; i < length; i++) {
            data[i] = new ArrayList<>();
        }
    }

    public void set(int index, int val) {
        data[index].add(new int[]{snap, val});
    }

    public int snap() {
        return snap++;
    }

    public int get(int index, int snap_id) {
        return binarySearch(data[index], snap_id);
    }

    private int binarySearch(List<int[]> list, int snap_id) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int index = list.get(mid)[0];
             if (index < snap_id + 1) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return list.get(left)[1];
    }

    public static void main(String[] args) {
        SnapshotArray snapshotArray = new SnapshotArray(1);
        snapshotArray.set(0, 15);
        System.out.println(snapshotArray.snap());
        System.out.println(snapshotArray.snap());
        System.out.println(snapshotArray.snap());
        System.out.println(snapshotArray.get(0, 2));
        System.out.println(snapshotArray.snap());
        System.out.println(snapshotArray.snap());
        System.out.println(snapshotArray.get(0, 0));
    }
}
