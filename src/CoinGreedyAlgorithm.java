/**
 * 这个问题在我们的日常生活中就更加普遍了。假设1元、2元、5元、10元、20元、50元、100元的纸币
 * 分别有c0, c1, c2, c3, c4, c5, c6张。现在要用这些钱来支付K元，至少要用多少张纸币？
 * 用贪心算法的思想，很显然，每一步尽可能用面值大的纸币即可。
 */
public class CoinGreedyAlgorithm {
    public static void main(String[] args) {
        //人民币面值集合
        int[] values={1,2,5,10,20,50,100};
        //各种面值对应数量集合
        int[] nums={3,1,2,1,1,3,5};
        //求442元人民币需各种面值多少张
        print(change(380,values,nums),values);
    }
    public static int[] change(int money,int[] values,int[] nums){
        int[] result=new int[values.length];
        for (int i = values.length-1; i >=0 ; i--) {
            int num=0;
            int c=min(money/values[i],nums[i]);
            money=money-c*values[i];
            result[i]=c;
        }
        return result;
    }
    //判断最接近目标值的人民币数量
    public static int min(int i,int j){
        return i>j?j:i;
    }
    public static void print(int[] result,int[] values){
        for (int i = 0; i < result.length; i++) {
            if (result[i]!=0){
                System.out.println("需要面值为"+values[i]+"的人民币"+result[i]+"张");
            }
        }
    }
}
