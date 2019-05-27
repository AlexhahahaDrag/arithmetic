import java.util.*;

/**
 * @Description: In a deck of cards, each card has an integer written on it.
 *
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
 *
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
 * Example 2:
 *
 * Input: [1,1,1,2,2,2,3,3]
 * Output: false
 * Explanation: No possible partition.
 * Example 3:
 *
 * Input: [1]
 * Output: false
 * Explanation: No possible partition.
 * Example 4:
 *
 * Input: [1,1]
 * Output: true
 * Explanation: Possible partition [1,1]
 * Example 5:
 *
 * Input: [1,1,2,2,2,2]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[2,2]
 *
 * Note:
 *
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 * @Author:      alex
 * @CreateDate:  2019/2/22 15:40
 * @param
 * @return
 */
public class XOfAKindInADeckOfCards {
    public static void main(String[] args) {
        XOfAKindInADeckOfCards x=new XOfAKindInADeckOfCards();
        int deck[]={0,0,0,1,1,1,2,2,2,2,2,2};
        System.out.println(x.hasGroupsSizeX(deck));
    }
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count= new int[10001];
        for (int i : deck)
            count[i]++;
        List<Integer> list =new ArrayList<>();
        for (int j: count)
            if (j>0)
                list.add(j);
            int gDen=count[deck[0]];
        for (int k: list)
            gDen=gcd(gDen,k);
        return gDen>1;
    }
    public boolean hasGroupsSizeX1(int[] deck) {
        int[] count=new int[10001];
        for (int i:deck)
            count[i]++;
        int gDen = count[deck[0]];
        for (int j : count )
            if (j>0)
                gDen=gcd(j,gDen);
        return gDen>1;
    }
    private int gcd(int x,int y){
        return x==0?y:gcd(y%x,x);
    }
}
