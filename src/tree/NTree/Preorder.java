package tree.NTree;

import java.util.ArrayList;
import java.util.List;

/**
 *description:
 * 589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 *
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *author:       alex
 *createDate:  2020/2/28 22:26
 *version:      1.0.0      
*/
public class Preorder {

    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node<Integer> root) {
        pre(root);
        return res;
    }

    private void pre(Node<Integer> root) {
        if(root == null)
            return;
        int index = root.children.size();
        res.add(root.val);
        for(int i = 0; i < index; i++)
            pre(root.children.get(i));
    }
}
