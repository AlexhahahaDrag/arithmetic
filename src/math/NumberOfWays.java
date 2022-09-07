package math;

public class NumberOfWays {

    private int res;
    public int numberOfWays1(int startPos, int endPos, int k) {
        if (startPos > endPos) {
            int temp = startPos;
            startPos = endPos;
            endPos = temp;
        }
        if(endPos - startPos > k || (k - endPos + startPos) % 2 != 0) {
            return 0;
        }
        res = 0;
        int mid = k - endPos + startPos >> 1;
        int left = mid;
        int right = mid + endPos - startPos;
        find(startPos, endPos, left, right, new int[k], 0);
        return res;
    }

    private void find(int start, int end, int left, int right, int[] k, int index) {
        if (left == 0 && right == 0) {
            if(start == end) {
                res++;
            }
            return;
        }
        k[index] = start;
        //向左向右移动
        if (left > 0) {
            find(start - 1, end, left - 1, right, k, index + 1);
        }
        if (right > 0) {
            find(start + 1, end, left, right - 1, k, index + 1);
        }
    }

    public int numberOfWays(int startPos, int endPos, int k) {
        return 0;
    }

    public static void main(String[] args) {
        int startPos = 1;
        int endPos = 2;
//        int k = 5;//10
        int k = 9;//35
        NumberOfWays numberOfWays = new NumberOfWays();
        System.out.println(numberOfWays.numberOfWays1(startPos, endPos, k));
        System.out.println(numberOfWays.numberOfWays(startPos, endPos, k));
    }
}
