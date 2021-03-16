package array;

public class StoneGameV {

    public int stoneGameV(int[] stoneValue) {
        int[] add = new int[stoneValue.length];
        add[0] = stoneValue[0];
        for (int i = 1; i < add.length; i++) {
            add[i] = add[i - 1] + stoneValue[i];
        }
        return findSum(add, 0, stoneValue.length - 1, 0);
    }

    private int findSum(int[] add, int i, int j, int pre) {
        if (i == j) {
            return 0;
        }
        if (i != pre) {
            for (int k = j; k >= i; k--) {
                add[k] = add[k] - add[i - 1];
            }
            add[i - 1] = 0;
            pre = i - 1;
        }
        int min = i;
        if (i + 1 == j) {
            return Math.min(add[i], add[j] - add[i]);
        } else {
            for(int k = i; k <= j; k++) {
                if (Math.abs(add[k] * 2 - add[j]) < Math.abs(add[min] * 2 - add[j])) {
                    min = k;
                }
                if (add[k] * 2 - add[j] >= 0) {
                    break;
                }
            }
        }
        if (add[min] * 2 == add[j]) {
            return add[min] - add[i] + Math.max(findSum(add, i, min, pre), findSum(add, min + 1, j, pre));
        } else if (add[min] * 2 < add[j]) {
            return (i == 0 ? add[min] : add[min] - add[min] - add[i- 1]) + findSum(add, i, min, pre);
        } else {
            return add[j] - add[min] + findSum(add, min + 1, j, pre);
        }
    }

    public static void main(String[] args) {
        int[] stoneValue = {9,8,2,4,6,3,5,1,7};
        StoneGameV stoneGameV = new StoneGameV();
        System.out.println(stoneGameV.stoneGameV(stoneValue));
    }
}
