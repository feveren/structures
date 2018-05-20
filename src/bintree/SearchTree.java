package bintree;

/**
 * 二叉搜索树
 * 1. 左子树所有节点都比根节点小
 * 2. 右子树所有节点都比根节点大
 * 3. 一般来说不会存在重复元素
 */
public class SearchTree implements Tree<Integer> {
    private BinTreeNode<Integer> mRoot;
    private int mSize;

    @Override
    public boolean isEmpty() {
        return mRoot == null;
    }

    @Override
    public int size() {
        return mSize;
    }

    @Override
    public void put(Integer data) {
        if (mRoot == null) {
            mRoot = createNode(data, null);
            return;
        }
        BinTreeNode<Integer> node = mRoot;
        while (node != null) {
            // 1. 比中间节点小，放到左子树
            if (data < node.data) {
                if (node.left == null) {
                    node.left = createNode(data, node);
                    return;
                } else {
                    node = node.left;
                }
            }
            // 2. 比中间节点大，放到右子树
            else if (data > node.data) {
                if (node.right == null) {
                    node.right = createNode(data, node);
                    return;
                } else {
                    node = node.right;
                }
            }
            // 3. 如果和当前节点相等，表示已经存在该节点，直接return
            else {
                return;
            }
        }
    }

    private BinTreeNode<Integer> createNode(Integer data, BinTreeNode<Integer> parent) {
        BinTreeNode<Integer> node = new BinTreeNode<>(data);
        node.parent = parent;
        mSize++;
        return node;
    }

    @Override
    public void remove(Integer data) {
        if (mRoot == null) {
            return;
        }
        BinTreeNode<Integer> node = mRoot;
        while (node != null) {
            // 1. 比中间节点小
            if (data < node.data) {
                node = node.left;
            }
            // 2. 比中间节点大
            else if (data > node.data) {
                node = node.right;
            }
            // 3. 和当前节点相等
            else {
                // 3.1 没有孩子节点
                // 1) 获取到node的父节点，然后将left或者right置空
                if (node.left == null && node.right == null) {
                    // 小于则说明在父节点的左子树，将parent.left置空
                    if (data < node.parent.data) {
                        node.parent.left = null;
                    }
                    // 大于则说明在父节点的右子树，将parent.right置空
                    else if (data > node.parent.data) {
                        node.parent.right = null;
                    }
                    node.parent = null;
                }
                // 3.2 只有左子树
                if (node.left != null && node.right == null) {
                    // 1) 将node.left的父节点指向node.parent
                    node.left.parent = node.parent;
                    // 2) 将父节点的左节点/右节点指向node.left
                    if (data < node.parent.data) {
                        node.parent.left = node.left;
                    }
                    else if (data > node.parent.data) {
                        node.parent.right = node.left;
                    }
                    // 3）将node的parent、left置空
                    node.parent = node.left = null;
                }
                // 3.3 只有右子树
                else if (node.left == null && node.right != null) {
                    // 1) 将node.right的父节点指向node.parent
                    node.right.parent = node.parent;
                    // 2) 将父节点的左节点/右节点指向node.right
                    if (data < node.parent.data) {
                        node.parent.left = node.right;
                    }
                    else if (data > node.parent.data) {
                        node.parent.right = node.right;
                    }
                    // 3）将node的parent、right置空
                    node.parent = node.right = null;
                }
                // 3.4 既有左子树，又有右子树
                else if (node.left != null && node.right != null) {
                    // 3.4.1 如果右子树有左子树
                    // 将右子树中最小的值，放到被删除的节点（也就是最左子树），因为他大于被删除的left，也小于被删除的右子树（因为是右子树最小的值）
                    // 3.4.2 如果右子树没有左子树
                    // 则右子树就是最小的节点，将右子树放到被删除的节点即可

                    // 1) 找到右子树最小的节点
                    BinTreeNode<Integer> rightMin = node.right;
                    while (rightMin.left != null) {
                        rightMin = rightMin.left;
                    }
                    // 6.1) 假如最小的节点就是自己，则不需要对右子树进行处理
                    // do nothing
                    // 6.2) 假如最小的不是自己，说明要移动的是他的最左子树
                    if (node.right != rightMin) {
                        // a) 如果右子树最小节点有右子树，则将最小节点的parent.left指向最小节点的右子树
                        rightMin.parent.left = null;
                        if (rightMin.right != null) {
                            rightMin.parent.left = rightMin.right;
                            rightMin.right.parent = rightMin.parent.left;
                        }
                        // b) 将右子树最小节点的右节点指向被删除节点的右节点
                        rightMin.right = node.right;
                        node.right.parent = rightMin;
                    }
                    // 2) 将他的parent指向被删除节点的parent
                    rightMin.parent = node.parent;
                    // 3) 将他的left指向被删除节点的left
                    rightMin.left = node.left;
                    // 4) 将node父节点的左孩子/右孩子指向右子树最小节点
                    if (node.parent.left == node) {
                        node.parent.left = rightMin;
                    }
                    else if (node.parent.right == node) {
                        node.parent.right = rightMin;
                    }
                    // 5) 将node的左孩子parent指向右子树最小节点
                    node.left.parent = rightMin;
                    // 将被删除节点的parent、left、right置空
                    node.parent = node.left = node.right = null;
                }
                mSize--;
                System.out.println("deleted: " + node);
                return;
            }
        }
    }

    void print() {
        TraversalTree.inOrderStack(mRoot);
        System.out.println();
    }

    /**
     *          10
     *     6         15
     *   5   8    11    20
     *  4          12  17
     *                  18
     *  8 没有左孩子，也没有右孩子
     *  5 有左孩子
     *  11 有右孩子
     *  6 有左孩子，也有右孩子，但是右孩子没有左孩子
     *  15 有左孩子，也有右孩子，右孩子有左孩子
     */
    public static void main(String[] args) {
        SearchTree searchTree = new SearchTree();
        searchTree.put(10);
        searchTree.put(6);
        searchTree.put(5);
        searchTree.put(4);
        searchTree.put(8);
        searchTree.put(15);
        searchTree.put(11);
        searchTree.put(12);
        searchTree.put(20);
        searchTree.put(17);
        searchTree.put(18);
        searchTree.print();

//        searchTree.remove(8);
//        searchTree.remove(5);
//        searchTree.remove(11);
        searchTree.remove(6);
//        searchTree.remove(15);

        searchTree.print();
    }
}
