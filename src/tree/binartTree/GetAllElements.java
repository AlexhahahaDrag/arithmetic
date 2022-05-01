package tree.binartTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *description:  
 *author:       alex
 *createDate:  2019/12/29 11:40
 *version:      1.0.0      
*/
public class GetAllElements {

    List<Integer> res = new ArrayList<>();
    List<Integer> remain = new ArrayList<>();
    int remainInd = 0;
    public List<Integer> getAllElements1(TreeNode root1, TreeNode root2) {
        getList(root1, root2);
        for(int i = remainInd; i < remain.size(); i++) {
            res.add(remain.get(remainInd));
        }
        return res;
    }
    private void getList(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            ;
        } else if(root1 == null) {
            getList(root1, root2.left);
            remain.add(root2.val);
            getList(root1, root2.right);
        } else if (root2 == null) {
            getList(root1.left, root2);
            remain.add(root1.val);
            getList(root1.right, root2);
        } else {
            getList(root1.left, root2.left);
            add(root1.val, root2.val);
            getList(root1.right, root2.right);
        }
    }
    private void add(int val1, int val2) {
        int val = Math.min(val1, val2);
        remain.add(Math.max(val1, val2));
        while(remain.get(remainInd) < val) {
            res.add(remain.get(remainInd++));
        }
        res.add(val);
    }

    public List<Integer> getAllElements2(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        List<Integer> list1  = new ArrayList<>();
        getL(root1, list1);
        List<Integer> list2 = new ArrayList<>();
        getL(root2, list2);
        int index1 = 0;
        int index2 = 0;
        int len1 = list1.size();
        int len2 = list2.size();
        while(index1 < len1 && index2 < len2) {
            if(list1.get(index1) < list2.get(index2)) {
                res.add(list1.get(index1++));
            } else {
                res.add(list2.get(index2++));
            }
        }
        while(index1 < len1) {
            res.add(list1.get(index1++));
        }
        while(index2 < len2) {
            res.add(list2.get(index2++));
        }
        return res;
    }

    private void getL(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        getL(treeNode.left, list);
        list.add(treeNode.val);
        getL(treeNode.right, list);
    }


    Queue<Integer> queue = new LinkedList<>();
    List<Integer> result = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        pre(root1, 0);
        pre(root2, 1);
        result.addAll(queue);
        return result;
    }

    private void pre(TreeNode root, int n) {
        if (n == 0) {
            if (root == null) {
                return;
            }
            pre(root.left, n);
            queue.add(root.val);
            pre(root.right, n);
        } else if (n == 1) {
            if (root == null) {
                return;
            }
            pre(root.left, n);
            while (!queue.isEmpty() && root.val > queue.peek()) {
                result.add(queue.poll());
            }
            result.add(root.val);
            pre(root.right, n);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,1,7,0,2};
        TreeNode treeNode = TreeNode.getTreeNodeByArr(arr);
        GetAllElements getAllElements = new GetAllElements();
        System.out.println(getAllElements.getAllElements(null, treeNode));
    }
}
