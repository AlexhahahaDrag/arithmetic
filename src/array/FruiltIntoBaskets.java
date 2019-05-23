package array;
/**
 * @Description: 904. Fruit Into Baskets
 * Medium
 *
 * 422
 *
 * 653
 *
 * Favorite
 *
 * Share
 * In a row of trees, the i-th tree produces fruit with type tree[i].
 *
 * You start at any tree of your choice, then repeatedly perform the following steps:
 *
 * Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 * Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 * Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.
 *
 * You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
 *
 * What is the total amount of fruit you can collect with this procedure?
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,1]
 * Output: 3
 * Explanation: We can collect [1,2,1].
 * Example 2:
 *
 * Input: [0,1,2,2]
 * Output: 3
 * Explanation: We can collect [1,2,2].
 * If we started at the first tree, we would only collect [0, 1].
 * Example 3:
 *
 * Input: [1,2,3,2,2]
 * Output: 4
 * Explanation: We can collect [2,3,2,2].
 * If we started at the first tree, we would only collect [1, 2].
 * Example 4:
 *
 * Input: [3,3,3,1,2,1,1,2,3,3,4]
 * Output: 5
 * Explanation: We can collect [1,2,1,1,2].
 * If we started at the first tree or the eighth tree, we would only collect 4 fruits.
 *
 *
 * Note:
 *
 * 1 <= tree.length <= 40000
 * 0 <= tree[i] < tree.length
 * @Author:      alex
 * @CreateDate:  2019/5/23 19:33
 * @param
 * @return
*/
public class FruiltIntoBaskets {
    public static void main(String[] args) {
        FruiltIntoBaskets fruiltIntoBaskets=new FruiltIntoBaskets();
        int[] arr={3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(fruiltIntoBaskets.totalFruit(arr));
    }
    public int totalFruit(int[] tree) {
        if(tree.length<=2)
            return tree.length;
        int maxStep=0;
        int index=0;
        int type=1;
        int i=0;
        while(i<tree.length){
            int step=1;
            int second=index;
            for( i=index+1; i < tree.length ; i++){
                if(tree[index]==tree[i]&&type==1){
                    index=i;
                }else if(tree[index]!=tree[i]&&tree[second]!=tree[i]){
                    second=i;
                    type++;
                    if(type>2){
                        index++;
                        type=1;
                        break;
                    }
                }
                step++;
            }
            maxStep=Math.max(maxStep,step);
        }
        return maxStep;
    }
}
