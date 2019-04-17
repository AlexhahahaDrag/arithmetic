import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrintLots {
    public static void main(String[] args) {
        List<Integer> p=new ArrayList<>();
        p.add(1);
        p.add(3);
        p.add(4);
        p.add(6);
        List<Integer> l=new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(7);
        printLots(l,p);
    }
    public static void printLots(List<Integer> l,List<Integer> p){
        System.out.println(new Date().getTime());
        for (int i:
             p) {
            System.out.println(l.get(i));
        }
        System.out.println(new Date().getTime());
    }
}
