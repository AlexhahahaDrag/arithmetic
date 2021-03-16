import java.util.*;

/**
 * @Description: Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 *
 * Examples 1
 * Input:
 *
 *   5
 *  /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 *
 *   5
 *  /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * @Author:      alex
 * @CreateDate:  2019/4/2 10:34
 * @param
 * @return
 */
public class MostFrequentSubtreeSum {
    static Map<Integer,Integer> map =new HashMap<>();
    static int maxTime=0;
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(5);
        treeNode.left=new TreeNode(14);
        treeNode.left.left=new TreeNode(1);
        int[] nums=findFrequentTreeSum(treeNode);
        for (int i:nums) {
            System.out.println(i);
        }
    }
    public static int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        getSum(root,list);
        int size=list.size();
        int[] results=new int[size];
        for (Integer i:list) {
            results[--size]=i;
        }
        return results;
    }
    public static int getSum(TreeNode root,List<Integer> list){
        if(root==null) {
            return 0;
        }
        int sum=root.val;
        int left=getSum(root.left,list);
        int right=getSum(root.right,list);
        sum+=left+right;
        int num=map.getOrDefault(sum,0)+1;
        map.put(sum,num);
        if (num>maxTime){
            maxTime=num;
            list.clear();
            list.add(sum);
        }else if (num==maxTime) {
            list.add(sum);
        }
        return sum;
    }
}


