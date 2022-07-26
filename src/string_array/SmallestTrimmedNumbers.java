package string_array;


public class SmallestTrimmedNumbers {


    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        Target[][] map = new Target[nums[0].length()][10];
        int len = nums[0].length();
        int c;
        int level;
        int pre;
        Target cur;
        for (int i = nums.length - 1; i >= 0; i--) {
            c = len;
            level = 0;
            pre = -1;
            while (--c >= 0) {
                cur = map[level][nums[i].charAt(c) - '0'];
                if (cur == null) {
                    cur = new Target();
                }
                cur.level = level;
                cur.index[cur.size++] = i;
                cur.count++;
                cur.pre = pre;
                map[level][nums[i].charAt(c) - '0'] = cur;
                pre = nums[i].charAt(c) - '0';
                level++;
            }

        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            res[i] = find(query[1] - 1, query[0], map);
        }
        return res;
    }

    private int find(int level, int index, Target[][] map) {
        int count = 0;
        Target[] cur = map[level];
        for (Target target : cur) {
            if (target == null) {
                continue;
            }
            if (count + target.count >= index) {
                if (target.count == 1) {
                    return target.index[0];
                } else {
                    if (level == 0) {
                        return target.index[target.size - index + count];
                    }
                    return find(level - 1, index - count, map);
                }
            }
            count += target.count;
        }
        return -1;
    }

    class Target {
        int level;
        int count;
        int pre;
        int[] index;
        int size = 0;

        public Target() {
            this.index = new int[101];
        }
    }

    public static void main(String[] args) {
        String[] nums = {"102","473","251","814"};
        int[][] queries = {{1,1},{2,3},{4,2},{1,2}};//2  2  1  0
//        String[] nums = {"24","37","96","04"};
//        int[][] queries = {{2,1},{2,2}};//2  2  1  0
        SmallestTrimmedNumbers smallestTrimmedNumbers = new SmallestTrimmedNumbers();
        int[] res = smallestTrimmedNumbers.smallestTrimmedNumbers(nums, queries);
        for(int i : res) {
            System.out.print(i + "  ");
        }
    }
}
