import java.util.Stack;

public class Hanoi {
    public static void main(String[] args) {
        hanoi(3,'A','B','C');
    }
    public static void hanoi1(int n,char from,char mid,char to){
        if (n==1)
            System.out.println("第1个塔从"+from+"到"+to);
        else{
            hanoi(n-1,from,to,mid);
            System.out.println("第"+n+"个塔从"+from+"到"+to);
            hanoi(n-1,mid,from,to);
        }
    }
    public static void hanoi(int n,char from,char mid,char to){
        Problem problem=new Problem(n,from,mid,to);
        Stack<Problem> stack=new Stack<>();
        stack.add(problem);
        while(!stack.empty()) {
            Problem p = stack.pop();
            if (p.n == 1)
                System.out.println("从" + p.from + "到" + p.to);
            else {
                stack.add(new Problem(p.n - 1, p.mid, p.from, p.to));
                stack.add(new Problem(1, p.from, p.mid, p.to));
                stack.add(new Problem(p.n-1,p.from,p.to,p.mid));
            }
        }
    }
}
class Problem{
    public Problem(int n, char from, char mid, char to) {
        this.n = n;
        this.from = from;
        this.mid = mid;
        this.to = to;
    }

    public Problem() {
    }
    int n;
    char from;
    char mid;
    char to;
}
