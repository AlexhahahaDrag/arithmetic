package tree.binartTree;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        LinkedList<TreeNode> list=new LinkedList<>();
        stringBuilder.append("[");
        stringBuilder.append(val);
        if (left!=null)
            list.add(left);
        if (right!=null)
            list.add(right);
        while(list.size()>0){
            stringBuilder.append(",");
            TreeNode tn=list.pop();
            if (tn.left!=null)
                list.add(tn.left);
            if (tn.right!=null)
                list.add(tn.right);
            stringBuilder.append(tn.val);
        }

        stringBuilder.append("]");
        return stringBuilder.toString();
    }
    public TreeNode add(Integer it,TreeNode treeNode){
        if (treeNode==null)
            return new TreeNode(it);
        if (treeNode.left==null)
            treeNode.left=add(it,treeNode.left);
        else if (treeNode.right==null)
            treeNode.right=add(it,treeNode.right);
        else
            add(it,treeNode.left);
        return treeNode;
    }
}

