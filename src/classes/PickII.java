package classes;

import java.util.Random;

/**
 *description:  
 *author:       majf
 *createDate:   2022/6/9 12:46
 *version:      1.0.0
 */
public class PickII {
    private int[] res;
    private int[][] rects;
    public PickII(int[][] rects) {
        res = new int[rects.length + 1];
        int i = 0;
        for(int[] rect : rects) {
            res[i + 1] = res[i] + (rect[2] - rect[0]) * (rect[3] - rect[1]);
            i++;
        }
        this.rects = rects;
    }

    public int[] pick() {
        Random random = new Random();
        int num = random.nextInt(res[res.length - 1] + 1);
        int i = find(num);
        num -= res[i - 1];
        int[] c = rects[i - 1];
        int row = c[2] - c[0];
        int i1 = num / row;
        int i2 = num % row;
        return new int[] {c[0] + i1, c[1] + i2};
    }

    private int find(int num) {
        int start = 0;
        int end = res.length - 1;
        int mid;
        while(start < end) {
            mid = start + (end - start >> 1);
            if (res[mid] >= num) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[][] rects = {{-2, -2, 1, 1}, {2, 2, 4, 16}};
        PickII pickII = new PickII(rects);
        int[] res = pickII.pick();
        for(int i : res) {
            System.out.print(i + " ");
        }
    }
}
