public class BinaryTree {
    private int _item = 0;                  // the item stored
    private BinaryTree _parent = null;    // reference to the parent node
    private BinaryTree _left = null;      // reference to the left child
    private BinaryTree _right = null;     // reference to the right child
    String output;
    public BinaryTree(int element) {           // constructor for a new tree
        _item = element;
    }

    public BinaryTree(int element, BinaryTree leftChild, BinaryTree  rightChild) {
        _item = element;
        _left = leftChild;
        _right = rightChild;
        if (_left != null) _left._parent = this;
        if (_right != null) _right._parent = this;
    }

    public boolean isRoot() { return this._parent == null; }

    public BinaryTree getRoot() {
        BinaryTree node = this;              // current (sub-)tree
        while(!node.isRoot()) {
            node = node._parent;
        }
        return node;
    }

    public void setElement(int element) {
        this._item = element;
    }

    public int getElement() {
        return this._item;
    }

    public BinaryTree getLeft() {
        return _left;
    }

    public BinaryTree getRight() {
        return _right;
    }

    public BinaryTree addLeft(BinaryTree tree) {
        BinaryTree oldLeftChild = _left;     // current left
        _left = tree;                           // new left

        if (tree != null) {
            tree._parent = this;
        }
        if (oldLeftChild != null) {
            oldLeftChild._parent = null;
        }
        return oldLeftChild;
    }

    public BinaryTree addRight(BinaryTree tree) {
        BinaryTree oldRightChild = _right;   // current right
        _right = tree;                          // new right

        if (tree != null) {
            tree._parent = this;
        }
        if (oldRightChild != null) {
            oldRightChild._parent = null;
        }
        return oldRightChild;
    }

    public static boolean isBST(BinaryTree node)
    {
        return (isBSTUtil(node, 0, 100));
    }

    public static boolean isBSTUtil(BinaryTree node, int min, int max)
    {

        if (node == null)
            return true;

        if (node.getElement() < min || node.getElement() > max)
            return false;

        return (isBSTUtil(node.getLeft(), min, node.getElement() - 1) && isBSTUtil(
                node.getRight(), node.getElement() + 1, max));
    }


    public static boolean isBalanced(BinaryTree root)
    {
        int lh; /* for height of left subtree */
        int rh; /* for height of right subtree */

        if (root == null)
            return true;

        lh = height(root.getLeft());
        rh = height(root.getRight());

        return Math.abs(lh - rh) <= 1 && isBalanced(root.getLeft())
                && isBalanced(root.getRight());
    }
    public static int max(int a, int b)
    {
        return Math.max(a, b);
    }
    public static int height(BinaryTree node)
    {
        if (node == null)
            return 0;

        return 1 + max(height(node.getLeft()), height(node.getRight()));
    }
    BinaryTree inorderRec(BinaryTree _parent)
    {

        if (_parent != null)
        {
            if (_parent.getLeft() != null)
                inorderRec(_parent.getLeft());
            else
                output =output+" "+"Lnull";
            if (!output.equals(""))
                output =output+" "+_parent.getElement();
            else
                output =output+""+_parent.getElement();
            if (_parent.getRight() != null)
                inorderRec(_parent.getRight());
            else
                output =output+" "+"Rnull";

        }
        return _parent;
    }
    BinaryTree inorderNext()
    {
        return inorderRec(this.getRoot());
    }
    public String toString()
    {
        output="";
        inorderNext();
        return output ;

    }
    public static void main(String[] args) {


        BinaryTree t1 = new BinaryTree(1);
        t1.addLeft(new BinaryTree(2));
        t1.addRight(new BinaryTree(3));
        t1.getRight().addLeft(new BinaryTree(4));
        t1.getRight().addRight(new BinaryTree(5));

        BinaryTree t2 = new BinaryTree(15);
        t2.addLeft(new BinaryTree(5));
        t2.addRight(new BinaryTree(20));

        t2.getRight().addLeft(new BinaryTree(18));
        t2.getRight().addRight(new BinaryTree(23));
        t2.getLeft().addLeft(new BinaryTree(4));
        t2.getLeft().addRight(new BinaryTree(6));

        if (isBST(t1) && isBalanced(t1))
            System.out.println("Tree t1 is AVL tree");
        else
            System.out.println("Tree t1 is not AVL tree");
        if (isBST(t2) && isBalanced(t2))
            System.out.println("Tree t1 is AVL tree");
        else
            System.out.println("Tree t1 is not AVL tree");

        BinaryTree tree = new BinaryTree(1);
        tree.addLeft(new BinaryTree(2));
        tree.addRight(new BinaryTree(3));
        tree.getLeft().addLeft(new BinaryTree(4));
        tree.getLeft().addRight(new BinaryTree(5));
        System.out.println( tree.toString());

    }
}
