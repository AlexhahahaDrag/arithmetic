import java.nio.BufferUnderflowException;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>{
    private static class BinaryNode<AnyType>{
        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;
        BinaryNode(AnyType theElement){
            this(theElement,null,null);
        }
        BinaryNode(AnyType theElement,BinaryNode<AnyType> lt,BinaryNode<AnyType> rt){
            element=theElement;
            left=lt;
            right=rt;
        }
    }
    private BinaryNode<AnyType> root;
    public BinarySearchTree(){
        root=null;
    }
    public void makeEmpty(){
        root=null;
    }
    public boolean isEmpty(){
        return root==null;
    }
    public boolean contains(AnyType x){
        return contains(x,root);
    }
    public AnyType findMin(){
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        return findMin(root).element;
    }
    public AnyType findMax(){
        if(isEmpty()) {
            throw new BufferUnderflowException();
        }
        return findMax(root).element;
    }
    public void insert(AnyType x){
        root=insert(x,root);
    }
    public void remove(AnyType x){
        root=remove(x,root);
    }
    public void printTree(){
        if (isEmpty()) {
            System.out.println("Empty tree");
        } else {
            printTree(root);
        }
    }
    private boolean contains(AnyType x,BinaryNode<AnyType> t){
        if (t==null) {
            return false;
        }
        if (x.compareTo(t.element)>0) {
            return contains(x,t.right);
        } else if (x.compareTo(t.element)<0) {
            return contains(x,t.left);
        } else {
            return true;
        }
    }
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t){
       if (t!=null){
            while (t.left!=null) {
                t=t.left;
            }
        }
        return t;
    }
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t){
        if (t.right!=null) {
            return findMax(t.right);
        }
        return t;
    }
    private BinaryNode<AnyType> insert(AnyType x,BinaryNode<AnyType> t){
        if (t==null) {
            return new BinaryNode<AnyType>(x,null,null);
        }
        int comparableResult=x.compareTo(t.element);
        if (comparableResult>0){
            t.right=insert(x,t.right);
        }else if (comparableResult<0) {
            t.left=insert(x,t.left);
        }
        return t;
    }
    private BinaryNode<AnyType> remove(AnyType x,BinaryNode<AnyType> t){
        if (t==null) {
            return t;
        }
        int comparableResult=x.compareTo(t.element);
        if (comparableResult>0) {
            t.right=remove(x,t.right);
        } else if (comparableResult<0) {
            t.left=remove(x,t.left);
        } else if (t.left!=null&&t.right!=null){
            t.element=findMin(t.right).element;
            t.right=remove(t.element,t.right);
        }else {
            t=t.right==null?t.left:t.right;
        }
        return t;
    }
    private void printTree(BinaryNode<AnyType> t){
        if (t.left!=null) {
            printTree(t.left);
        }
        System.out.println(t.element);
        if (t.right!=null) {
            printTree(t.right);
        }
    }
}
