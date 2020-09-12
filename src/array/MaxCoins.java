package array;

import java.util.Arrays;

public class MaxCoins {

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int sum = 0;
        for (int i = piles.length - 2; i >= piles.length / 3; i -= 2)
            sum += piles[i];
        return sum;
    }


    public static void main(String[] args) {
        MaxCoins maxCoins = new MaxCoins();
      /*  System.out.println(maxCoins.maxCoins(piles));*/
    }

}
