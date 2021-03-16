package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *description:
 * 841. 钥匙和房间
 * 难度
 * 中等
 *
 * 142
 *
 * 收藏
 *
 * 分享
 *
 * 切换为英文
 *
 * 关注
 *
 * 反馈
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 * 你可以自由地在房间之间来回走动。
 * 如果能进入每个房间返回 true，否则返回 false。
 *
 * 示例 1：
 * 输入: [[1],[2],[3],[]]
 * 输出: true
 * 解释:
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 * 示例 2：
 * 输入：[[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 * 提示：
 * 1 <= rooms.length <= 1000
 * 0 <= rooms[i].length <= 1000
 * 所有房间中的钥匙数量总计不超过 3000。
 *author:       alex
 *createDate:   2020/8/31 21:59
 *version:      1.0.0
 */
public class CanVisitAllRooms {

    public boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) {
            return true;
        }
        int roomNum = rooms.size();
        boolean[] map = new boolean[roomNum];
        Stack<Integer> stack = new Stack<>();
        stack.addAll(rooms.get(0));
        map[0] = true;
        while(!stack.isEmpty() && roomNum != 0) {
            int room = stack.pop();
            if (map[room]) {
                continue;
            }
            map[room] = true;
            stack.addAll(rooms.get(room));
            roomNum--;
        }
        return roomNum == 1;
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] map = new boolean[rooms.size()];
        int count = dfs(rooms, map, 0);
        return count == rooms.size();
    }

    private int dfs(List<List<Integer>> rooms, boolean[] map, int index) {
        int result = 1;
        map[index] = true;
        for (Integer in : rooms.get(index)) {
            if (!map[in]) {
                result += dfs(rooms, map, in);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
       /* List<Integer> li1 = new ArrayList<>();
        li1.add(1);
        List<Integer> li2 = new ArrayList<>();
        li2.add(2);
        List<Integer> li3 = new ArrayList<>();
        li1.add(3);
        List<Integer> li4 = new ArrayList<>();
        rooms.add(li1);
        rooms.add(li2);
        rooms.add(li3);
        rooms.add(li4);*/
        List<Integer> li1 = new ArrayList<>();
        li1.add(1);
        li1.add(3);
        List<Integer> li2 = new ArrayList<>();
        li2.add(3);
        li2.add(0);
        li2.add(1);
        List<Integer> li3 = new ArrayList<>();
        li3.add(2);
        List<Integer> li4 = new ArrayList<>();
        rooms.add(li1);
        rooms.add(li2);
        rooms.add(li3);
        rooms.add(li4);
        CanVisitAllRooms canVisitAllRooms = new CanVisitAllRooms();
        System.out.println(canVisitAllRooms.canVisitAllRooms(rooms));
    }
}
