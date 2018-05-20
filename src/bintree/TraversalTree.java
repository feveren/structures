package bintree;

import java.util.Stack;

public class TraversalTree {

    /**
     *          A
     *      B       F
     *   C    D        G
     *      E         H
     *
     */
    public static void main(String[] args) {
        BinTreeNode<String> aNode = new BinTreeNode<>("A");
        BinTreeNode<String> bNode = new BinTreeNode<>("B");
        aNode.left = bNode;
        bNode.left = new BinTreeNode<>("C");
        BinTreeNode<String> dNode = new BinTreeNode<>("D");
        bNode.right = dNode;
        dNode.left = new BinTreeNode<>("E");
        BinTreeNode<String> fNode = new BinTreeNode<>("F");
        aNode.right = fNode;
        BinTreeNode<String> gNode = new BinTreeNode<>("G");
        fNode.right = gNode;
        gNode.left = new BinTreeNode<>("H");

        preOrder(aNode);
        System.out.println();
        preOrderStack(aNode);
        System.out.println();
        inOrder(aNode);
        System.out.println();
        inOrderStack(aNode);
        System.out.println();
        postOrder(aNode);
        System.out.println();
        postOrderStack(aNode);
        System.out.println();
    }

    private static void preOrder(BinTreeNode<String> treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.data + " ");
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    private static void inOrder(BinTreeNode<String> treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        System.out.print(treeNode.data + " ");
        inOrder(treeNode.right);
    }

    private static void postOrder(BinTreeNode<String> treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        System.out.print(treeNode.data + " ");
    }

    public static void preOrderStack(BinTreeNode<?> treeNode) {
        Stack<BinTreeNode<?>> stack = new Stack<>();
        BinTreeNode<?> node = treeNode;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                System.out.print(node.data + " ");
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    public static void inOrderStack(BinTreeNode<?> treeNode) {
        Stack<BinTreeNode<?>> stack = new Stack<>();
        BinTreeNode<?> node = treeNode;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.data + " ");
                node = node.right;
            }
        }
    }

    public static void postOrderStack(BinTreeNode<?> treeNode) {
        Stack<BinTreeNode<?>> stack = new Stack<>();
        Stack<BinTreeNode<?>> output = new Stack<>();
        BinTreeNode<?> node = treeNode;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                output.push(node);
                stack.push(node);
                node = node.right;
            } else {
                node = stack.pop();
                node = node.left;
            }
        }
        while (!output.isEmpty()) {
            node = output.pop();
            System.out.print(node.data + " ");
        }
    }
}
