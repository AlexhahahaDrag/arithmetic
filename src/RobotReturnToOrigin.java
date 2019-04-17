public class RobotReturnToOrigin {
    public static void main(String[] args) {
        System.out.println(judgeCircle("UD"));
    }
    public static boolean judgeCircle(String moves) {
        int[] cnt = new int[128];
        for (char c : moves.toCharArray())
            cnt[c]++;
        return cnt['L'] == cnt['R'] && cnt['U'] == cnt['D'];
    }
    public static boolean judgeCircle1(String moves) {
        int count=0;
        int index=0;
        for(int i=0;i<moves.length();i++){
            switch(moves.charAt(i)){
                case 'U':count++;break;
                case 'D':count--;break;
                case 'L':index++;break;
                case 'R':index--;break;
            }
        }
        if(index==0&&count==0)
            return true;
        return false;
    }
}
