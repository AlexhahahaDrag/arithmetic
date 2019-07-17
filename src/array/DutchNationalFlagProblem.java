package array;

/**
 * @Description:”荷兰国旗难题“问题描述
 *
 * 　　”荷兰国旗难题“是计算机科学中的一个程序难题，它是由Edsger Dijkstra提出的。荷兰国旗是由红、白、蓝三色组成的。
 *
 *
 *
 * 　　现在有若干个红、白、蓝三种颜色的球随机排列成一条直线。现在我们的任务是把这些球按照红、白、蓝排序。
 * @Author:      alex
 * @CreateDate:  ${DATE} ${TIME}
 * @Version:     1.0.0
*/
public class DutchNationalFlagProblem {
    public static void main(String[] args) {
        DutchNationalFlagProblem dutchNationalFlagProblem = new DutchNationalFlagProblem();
        int[] arr = {0, 1 , 2, 1, 1, 2, 0, 1, 0, 1};
        int[] arrSort = dutchNationalFlagProblem.getDutchNationalFlagSort(arr);
        for (int i : arrSort)
            System.out.println(i);
    }
    public int[] getDutchNationalFlagSort1(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int current = 0;
        while(current < end) {
            if(arr[current] == 0) {
                swap(arr, start, current);
                current++;
                start++;
            } else if (arr[current] == 1) {
                current++;
            } else if(arr[current] == 2) {
                swap(arr, current, end);
                end--;
            }
        }
        return arr;
    }
    public int[] getDutchNationalFlagSort(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int current = 0;
        while(current < end) {
            while(arr[current] == 0) {
                if (current != start)
                    swap(arr, start, current);
                current++;
                start++;
            }
            while (arr[current] == 1) {
                current++;
            }
            while (arr[end] == 2)
                end--;
            while (current < end && arr[current] == 2) {
                swap(arr, current, end);
                end--;
            }
        }
        return arr;
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
