package array;

public class ValidPartition {

    public boolean validPartition(int[] nums) {
        int[] map = new int[1000001];
        for(int i : nums) {
            map[i]++;
        }
        for(int i = 0; i < map.length; i++) {
            if (map[i] == 0) {
                continue;
            }
            if (!find(map, i, 0, 0)) {
                return false;
            }
        }
        return true;
    }

    //type:0:完成  1：递增
    private boolean find(int[] map, int i, int type, int count) {
        boolean res = false;
        if (type == 0) {
            switch (map[i]) {
                case 0:
                    return true;
                case 1:
                    res |= find(map, i + 1, 1, 1);
                    break;
                case 2 :
                    res |= find(map, i + 1, 0, 0);
                    break;
                default :
                    res |= find(map, i + 1, 0, 0);
                    res |= find(map, i + 1, 1, 1);
            }
            return res;
        } else {
            if (map[i] == 0 || map[i] == 2) {
                return false;
            }
            if (count == 1) {
                return find(map, i + 1, 1, 2);
            } else {
                return find(map, i + 1, 0, 0);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,3};
        ValidPartition validPartition = new ValidPartition();
        System.out.println(validPartition.validPartition(nums));
    }
}
