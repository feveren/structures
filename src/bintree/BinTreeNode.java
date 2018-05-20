package bintree;

public class BinTreeNode<T> {
    public T data;
    public BinTreeNode<T> parent;
    public BinTreeNode<T> left;
    public BinTreeNode<T> right;

    public BinTreeNode() {
    }

    public BinTreeNode(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BinTreeNode{" +
                "data=" + data +
                ", parent=" + parent +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
