/**
 * @Description: We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 *
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 *
 * -1 : My number is lower
 *  1 : My number is higher
 *  0 : Congrats! You got it!
 * Example :
 *
 * Input: n = 10, pick = 6
 * Output: 6
 * @Author:      alex
 * @CreateDate:  2019/2/26 13:54
 * @param
 * @return
*/
public class GuessNumberHigherOrLower {
    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }
    public static int guessNumber(int n) {
        int low = 1;
        while (low<=n) {
            int mid=low+(n-low>>>1);
            int res = guess(mid);
            switch (res){
                case 0:return mid;
                case -1:n = mid - 1;break;
                default:low = mid + 1;
            }
        }
        return -1;
    }
    public static int guess(int num) {
        int target=6;
        if (target==num) {
            return 0;
        } else if (target>num) {
            return 1;
        } else {
            return -1;
        }
    }
}
