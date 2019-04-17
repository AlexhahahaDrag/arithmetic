/**
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
 *
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 *
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 * Note:
 * The input array won't violate no-adjacent-flowers rule.
 * The input array size is in the range of [1, 20000].
 * n is a non-negative integer which won't exceed the input array size.
 */
public class CanPlaceFlower {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 0, 0};
        System.out.println(canPlaceFlowers1(arr, 1));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        switch (flowerbed.length) {
            case 0:
                return false;
            case 1:
                if (flowerbed[0] == 0)
                    n--;
                break;
            case 2:
                if (flowerbed[0] == 0 && flowerbed[1] == 0)
                    n--;
                break;
            default:
                for (int i = 0; i < flowerbed.length - 2; i++) {
                    if (flowerbed[0] == 0 && flowerbed[1] == 0) {
                        flowerbed[0] = 1;
                        n--;
                    }
                    if (flowerbed[flowerbed.length - 2] == 0 && flowerbed[flowerbed.length - 1] == 0) {
                        flowerbed[flowerbed.length - 1] = 1;
                        n--;
                    }
                    if (flowerbed[i] == 0 && flowerbed[i + 1] == 0 && flowerbed[i + 2] == 0) {
                        flowerbed[i + 1] = 1;
                        n--;
                    }
                    if (n == 0)
                        return true;
                }
        }
        if (n <= 0)
            return true;
        return false;
    }

    public static boolean canPlaceFlowers1(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) return false;
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                i++; // we know that the next index won't be a candidate, so go to the next-next index
                continue;
            }
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                count++;
                i++;  // we know that the next index won't be a candidate, so go to the next-next index
            }
            if (count == n) return true;
        }
        return n == 0; // I missed this case, but this just returns true if n==0 and there are no spots to plant a flower
    }
}
