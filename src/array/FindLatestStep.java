package array;

public class FindLatestStep {
    int count = 0;
    public int findLatestStep(int[] arr, int m) {
        int[] map = new int[arr.length];
        int step = 0;
        int res = 0;
        for(int i : arr) {
            step++;
            find(map, i - 1, m);
            if (count != 0)
                res =  step;
        }
        return res == 0 ? - 1 : res;
    }

    private void find(int[] map, int i, int m) {
        int sum = 1;
        if(i - 1 >= 0 && map[i - 1] != 0) {
            if (map[i - 1] == m)
                count--;
            sum += map[i - 1];
        }
        if (i + 1 < map.length && map[i + 1] != 0){
            if (map[i + 1] == m)
                count--;
            sum += map[i + 1];
        }
        if (sum == m)
            count++;
        if(i - 1 >= 0)
            map[i - map[i - 1]] = sum;
        if (i + 1 < map.length)
            map[i + map[i + 1]] = sum;
    }

    public static void main(String[] args) {
        int m = 1;
        int[] arr = {1};
        FindLatestStep findLatestStep = new FindLatestStep();
        System.out.println(findLatestStep.findLatestStep(arr, m));
    }
}
