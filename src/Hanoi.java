public class Hanoi {
    public static void main(String[] args) {
        hanoi(4,'A','B','C');
    }
    public static void hanoi(int n,char from,char mid,char to){
        if (n==1)
            System.out.println("第1个塔从"+from+"到"+to);
        else{
            hanoi(n-1,from,to,mid);
            System.out.println("第"+n+"个塔从"+from+"到"+to);
            hanoi(n-1,mid,from,to);
        }
    }
}
