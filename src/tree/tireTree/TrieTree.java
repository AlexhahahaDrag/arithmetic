package tree.tireTree;

public class TrieTree<T> {
    public T val;
    public boolean isEnd;
    public TrieTree<T>[] children;

    public TrieTree(T val) {
        this.val = val;
        children = new TrieTree[256];
    }

    public TrieTree() {
    }
}
