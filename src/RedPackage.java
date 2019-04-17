import java.util.Random;

public class RedPackage {
    public static void main(String[] args) {
        Package pg=new Package(10,200);
        for (;pg.remainNum!=0; ) {
            System.out.println(getRedPackage(pg));
        }
    }
    public static double getRedPackage(Package pg){
        if (pg.remainNum==1){
            pg.remainNum--;
            return (double)Math.round(pg.remainMoney*100)/100;
        }
        Random r=new Random();
        double min = 0.01;
        double max = pg.remainMoney/pg.remainNum*2;
        double money = r.nextDouble()*max;
        money=money<min?0.01:money;
        money=Math.floor(money*100)/100;
        pg.remainNum--;
        pg.remainMoney=pg.remainMoney-money;
        return money;
    }
}
class Package{
    int remainNum;
    double remainMoney;

    public Package(int remainNum, double remainMoney) {
        this.remainNum = remainNum;
        this.remainMoney = remainMoney;
    }
}
