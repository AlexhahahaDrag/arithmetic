package tree.binartTree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(Integer x) { val = x; }
    Integer deep;

    @Override
    public String toString() {
        if (val == null) {
            return null;
        }
        StringBuilder stringBuilder=new StringBuilder();
        LinkedList<TreeNode> list=new LinkedList<>();
        stringBuilder.append("[");
        stringBuilder.append(val);
        if (left!=null) {
            list.add(left);
        }
        if (right!=null) {
            list.add(right);
        }
        while(list.size()>0){
            stringBuilder.append(",");
            TreeNode tn=list.pop();
            if (tn.left!=null) {
                list.add(tn.left);
            }
            if (tn.right!=null) {
                list.add(tn.right);
            }
            stringBuilder.append(tn.val);
        }

        stringBuilder.append("]");
        return stringBuilder.toString();
    }
    public static TreeNode add(Integer it,TreeNode treeNode){
        if (treeNode==null) {
            TreeNode treeNode1 = new TreeNode(it);
            treeNode1.deep = 1;
            return treeNode1;
        }

        if (treeNode.left==null) {
            treeNode.left=add(it,treeNode.left);
            treeNode.deep = Math.max(treeNode.left == null ? 0 : treeNode.left.deep, treeNode.right == null ? 0 : treeNode.right.deep) + 1;
        } else if (treeNode.right==null) {
            treeNode.right=add(it,treeNode.right);
            treeNode.deep = Math.max(treeNode.left == null ? 0 : treeNode.left.deep, treeNode.right == null ? 0 : treeNode.right.deep) + 1;
        } else {
            if ((treeNode.left == null ? 0 : treeNode.left.deep) <= (treeNode.right == null ? 0 : treeNode.right.deep)) {
                add(it,treeNode.left);
            } else {
                add(it, treeNode.right);
            }
            treeNode.deep = Math.max(treeNode.left == null ? 0 : treeNode.left.deep, treeNode.right == null ? 0 : treeNode.right.deep) + 1;

        }

        return treeNode;
    }

    public static TreeNode getTreeNodeByArr(int[] arr) {
        TreeNode treeNode = null;
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        treeNode = get(treeNode, arr, 0, queue);
        return treeNode;
    }

    private static TreeNode get(TreeNode treeNode, int[] arr, int index, Queue<TreeNode> queue) {
        if(index < arr.length) {
            if(treeNode == null) {
                treeNode = new TreeNode(arr[index++]);
                get(treeNode, arr, index, queue);
            }else if (treeNode.left == null) {
                treeNode.left = new TreeNode(arr[index++]);
                queue.add(treeNode.left);
                get(treeNode, arr, index, queue);
            } else if (treeNode.right == null) {
                treeNode.right = new TreeNode(arr[index++]);
                queue.add(treeNode.right);
                get(treeNode, arr, index, queue);
            } else {
                get(queue.poll(), arr, index, queue);
            }
        }
        return treeNode;
    }

    public static TreeNode getTreeNodeByArr(Integer[] arr) {
        return get(arr, 0);
    }

    private static TreeNode get(Integer[] arr, int i) {
        if (i >= arr.length || arr[i] == null) {
            return null;
        }
        TreeNode tree = new TreeNode(arr[i]);
        tree.left = get(arr, i * 2 + 1);
        tree.right = get(arr, i * 2 + 2);
        return tree;
    }
}

