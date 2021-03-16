import java.nio.BufferUnderflowException;

public class AVLTree<AnyType extends Comparable<? super AnyType>> {
    private AvlNode<AnyType> root;
    public AVLTree(){
        root=null;
    }
    public boolean isEmpty(){
        return root==null;
    }
    private static class AvlNode<AnyType>{
        AvlNode(AnyType element){
            this(element,null,null);
        }
        AvlNode(AnyType theElement,AvlNode<AnyType> lt,AvlNode<AnyType> rt){
            element=theElement;
            left=lt;
            right=rt;
        }
        AnyType element;
        AvlNode<AnyType> left;
        AvlNode<AnyType> right;
        int height;
    }
    private int height(AvlNode<AnyType> t){
        return t==null?-1:t.height;
    }
    public AvlNode<AnyType> insert(AnyType x){
        return insert(x,root);
    }
    private AvlNode<AnyType> insert(AnyType x,AvlNode<AnyType> t){
        if(t==null) {
            return new AvlNode<>(x,null,null);
        }
        int compareResult=x.compareTo(t.element);
        if (compareResult<0) {
            insert(x,t.left);
        } else if (compareResult>0) {
            insert(x,t.right);
        }
        return balance(t);
    }
    private static final int ALLOWED_IMBALANCE = 1;
    private AvlNode<AnyType> balance(AvlNode<AnyType> t){
        if (t==null) {
            return t;
        }
        if (height(t.left)-height(t.right)>ALLOWED_IMBALANCE){
            if (height(t.left.left)>=height(t.left.right)) {
                t=rotateWithLeftChild(t);
            } else {
                t=doubleWithLeftChild(t);
            }
        }else if (height(t.right)-height(t.left)>ALLOWED_IMBALANCE){
            if (height(t.right.left)>=height(t.right.right)) {
                t=rotateWithLeftChild(t);
            } else {
                t=doubleWithRightChild(t);
            }
        }
        t.height=Math.max(height(t.left),height(t.right))+1;
        return t;
    }
    private AvlNode<AnyType> rotateWithLeftChild(AvlNode<AnyType> k2){
        AvlNode<AnyType> k1=k2.left;
        k2.left=k1.right;
        k1.right=k2;
        k2.height=Math.max(height(k1.right),height(k2.right))+1;
        k1.height=Math.max(height(k1.left),k2.height)+1;
        return k1;
    }
    private AvlNode<AnyType> rotateWithRightChild(AvlNode<AnyType> k2){
        AvlNode<AnyType> k1=k2.right;
        k2.right=k1.left;
        k1.left=k2;
        k2.height=Math.max(height(k1.left),height(k2.left))+1;
        k1.height=Math.max(height(k1.right),k2.height)+1;
        return k1;
    }
    private AvlNode<AnyType> doubleWithLeftChild(AvlNode<AnyType> k3){
        k3.left=rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }
    private AvlNode<AnyType> doubleWithRightChild(AvlNode<AnyType> k3){
        k3.right=rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }
    private AvlNode<AnyType> remove(AnyType x,AvlNode<AnyType> t){
        if (t==null) {
            return t;
        }
        int compareResult=x.compareTo(t.element);
        if (compareResult<0) {
            t.left=remove(x,t.left);
        } else if (compareResult>0) {
            t.right=remove(x,t.right);
        } else if (t.left!=null&&t.right!=null){
            t.element=findMin(t.right).element;
            t.right=remove(t.element,t.right);
        }else {
            t=t.left==null?t.right:t.left;
        }
        return balance(t);
    }
    public AnyType findMin(){
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        return findMin(root).element;
    }
    private AvlNode<AnyType> findMin(AvlNode t){
        while(t.left!=null) {
            t=t.left;
        }
        return t;
    }
}
