public class NumberOf1Bit {
    public static void main(String[] args) {
        System.out.println(hammingWeight(256));
    }
    public static int hammingWeight(int n) {
        int count=0;
        int a=0;
        while(n>0){
            if(n%2>0){
                count++;
            }
            n/=2;
        }
        return count;
    }
}
