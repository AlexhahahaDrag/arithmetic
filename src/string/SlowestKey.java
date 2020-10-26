package string;

/**
 *description:  
 *author:       alex
 *createDate:   2020/10/25 10:39
 *version:      1.0.0
 */
public class SlowestKey {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = 0;
        int num = releaseTimes[0];
        for(int i = 1;i < releaseTimes.length; i++) {
            if(releaseTimes[i] - releaseTimes[i - 1] > num) {
                num = releaseTimes[i] - releaseTimes[i - 1];
                max = i;
            } else if (releaseTimes[i] - releaseTimes[i - 1] == num && keysPressed.charAt(i) > keysPressed.charAt(max))
                max = i;
        }
        return keysPressed.charAt(max);
    }

    public static void main(String[] args) {
        int[] releaseTimes = {9,29,49,50};
        String keysPressed = "cbcd";
        SlowestKey slowestKey = new SlowestKey();
        System.out.println(slowestKey.slowestKey(releaseTimes, keysPressed));
    }
}
