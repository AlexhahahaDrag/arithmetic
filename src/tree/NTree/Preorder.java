package tree.NTree;

import java.util.*;

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
    public List<Integer> preorder1(Node<Integer> root) {
        pre(root);
        return res;
    }

    private void pre(Node<Integer> root) {
        if(root == null) {
            return;
        }
        res.add(root.val);
        if (root.children != null) {
            int index = root.children.size();
            for(int i = 0; i < index; i++) {
                pre(root.children.get(i));
            }
        }
    }

    public List<Integer> preorder(Node<Integer> root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node<Integer> cur = stack.pop();
            if (cur != null) {
                res.add(cur.val);
                if (cur.children != null && cur.children.size() > 0) {
                    for (int i = cur.children.size() - 1; i >= 0; i--) {
                        stack.push(cur.children.get(i));
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>();
        root.val = 1;
        List<Node<Integer>> children1 = new ArrayList<>();
        root.children = children1;
        Node<Integer> root3 = new Node<>();
        root3.val = 3;
        children1.add(root3);
        Node<Integer> root2 = new Node<>();
        root2.val = 2;
        children1.add(root2);
        Node<Integer> root4 = new Node<>();
        root4.val = 4;
        children1.add(root4);
        List<Node<Integer>> children3 = new ArrayList<>();
        Node<Integer> root5 = new Node<>();
        root5.val = 5;
        children3.add(root5);
        Node<Integer> root6 = new Node<>();
        root6.val = 6;
        children3.add(root6);
        root3.children = children3;
        Preorder preorder = new Preorder();
        System.out.println(preorder.preorder(root));
        System.out.println(preorder.preorder1(root));
    }
}
