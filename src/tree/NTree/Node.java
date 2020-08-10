package tree.NTree;

import java.util.List;

/**
 *description:  N叉树
 *author:       alex
 *createDate:  2020/2/28 22:25
 *version:      1.0.0
*/
public class Node<T> {

    public T val;
    public List<Node<T>> children;

    public Node() {}

    public Node(T _val) {
        val = _val;
    }

    public Node(T _val, List<Node<T>> _children) {
        val = _val;
        children = _children;
    }
}
