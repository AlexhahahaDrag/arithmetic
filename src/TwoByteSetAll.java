public class TwoByteSetAll {
    public static void main(String[] args) {
        String A = "11010011";
        String B = "10101110";
        System.out.println(judgeIfAllPositionSeted(A,B));
    }
    public static boolean judgeIfAllPositionSeted(String a,String b){
        int a10=Integer.valueOf(a,2);
        int b10=Integer.valueOf(b,2);
        System.out.println(a10|b10);
        return (a10|b10)==0xff;
    }
}
