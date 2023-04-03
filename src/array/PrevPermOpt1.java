package array;

public class PrevPermOpt1 {

    public int[] prevPermOpt1(int[] arr) {
        int len = arr.length;
        int temp;
        for(int i = len - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                int j = len - 1;
                while(arr[j] >= arr[i] || arr[j] == arr[j - 1]) {
                    j--;
                }
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                break ;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 1, 3};
        PrevPermOpt1 prevPermOpt1 = new PrevPermOpt1();
        int[] res = prevPermOpt1.prevPermOpt1(arr);
        for (int i : res) {
            System.out.print(i + ",");
        }
    }
}
