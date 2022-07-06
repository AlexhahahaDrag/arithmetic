package twoDimensionalArray;

import listNode.ListNode;

import java.util.Arrays;

/**
 *description:
 *author:       alex
 *createDate:   2022/7/3 10:57
 *version:      1.0.0
 */
public class SpiralMatrix {

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for(int[] i : res) {
            Arrays.fill(i, -1);
        }
        if (m == 1) {
            int index = 0;
            while(head != null) {
                res[0][index++] = head.val;
                head = head.next;
            }
            return res;
        }
        int[][] dic = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int i = 0;
        int x = 0;
        int y = 0;
        res[0][0] = head.val;
        head = head.next;
        while(head != null) {
            while(x + dic[i][0] >= 0 && x + dic[i][0] < m && y + dic[i][1] >= 0 && y + dic[i][1] < n
                    && res[x + dic[i][0]][y + dic[i][1]] == -1 && head != null) {
                res[x + dic[i][0]][y + dic[i][1]] = head.val;
                head = head.next;
                x += dic[i][0];
                y += dic[i][1];
            }
            i = ++i % 4;
        }
        return res;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 5;
        int[] arr = {3,0,2,6,8,1,7,9,4,2,5,5,0};
        ListNode head = ListNode.getListNodeByArr(arr);
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] res = spiralMatrix.spiralMatrix(m, n, head);
        for (int[] i :res) {
            for(int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
