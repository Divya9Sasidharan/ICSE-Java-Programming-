public class BinaryTree<T> {
    private T _item = null;                  // the item stored
    private BinaryTree<T> _parent = null;    // reference to the parent node
    private BinaryTree<T> _left = null;      // reference to the left child
    private BinaryTree<T> _right = null;     // reference to the right child

    public BinaryTree(T element) {           // constructor for a new tree
        _item = element;
    }

    public BinaryTree(T element, BinaryTree<T> leftChild, BinaryTree<T> rightChild) {
        _item = element;
        _left = leftChild;
        _right = rightChild;
        if (_left != null) _left._parent = this;
        if (_right != null) _right._parent = this;
    }

    public boolean isRoot() { return this._parent == null; }

    public BinaryTree<T> getRoot() {
        BinaryTree<T> node = this;              // current (sub-)tree
        while(!node.isRoot()) {
            node = node._parent;
        }
        return node;
    }

    public void setElement(T element) {
        this._item = element;
    }

    public T getElement() {
        return this._item;
    }

    public BinaryTree<T> getLeft() {
        return _left;
    }

    public BinaryTree<T> getRight() {
        return _right;
    }

    public BinaryTree<T> addLeft(BinaryTree<T> tree) {
        BinaryTree<T> oldLeftChild = _left;     // current left
        _left = tree;                           // new left

        if (tree != null) {
            tree._parent = this;
        }
        if (oldLeftChild != null) {
            oldLeftChild._parent = null;
        }
        return oldLeftChild;
    }

    public BinaryTree<T> addRight(BinaryTree<T> tree) {
        BinaryTree<T> oldRightChild = _right;   // current right
        _right = tree;                          // new right

        if (tree != null) {
            tree._parent = this;
        }
        if (oldRightChild != null) {
            oldRightChild._parent = null;
        }
        return oldRightChild;
    }
}
