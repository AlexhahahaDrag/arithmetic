package math;

public class PeopleAwareOfSecret {

    private int[] map;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        map = new int[n];
        get(0, n, delay, forget);
        int sum = 0;
        map[0] = 1;
        int mod = (int)1e9 + 7;
        for(int i : map) {
            sum = (sum + i) % mod;
        }
        return sum;
    }

    private void get(int i, int n, int delay, int forget) {
        if (i + delay >= n) {
            return;
        }
        int len = Math.min(n, i + forget);
        for(int s = i + delay; s < len; s++) {
            map[s]++;
            get(s, n, delay, forget);
        }
        if (i + forget < n) {
            map[i + forget]--;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int delay = 2;
        int forget = 4;
        PeopleAwareOfSecret peopleAwareOfSecret = new PeopleAwareOfSecret();
        System.out.println(peopleAwareOfSecret.peopleAwareOfSecret(n, delay, forget));
    }
}
