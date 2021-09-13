//REFERENCES++++
//https://stackoverflow.com/questions/28559101/implement-bst-using-comparable-or-comparator
//https://www.programiz.com/dsa/binary-search-tree
//https://www.javatpoint.com/java-program-to-search-a-node-in-a-binary-tree
//https://www.baeldung.com/java-binary-tree

public class InvertedSearchTree<T extends Comparable<T>> {
    class Node<T>
    {
        T obj;
        Node<T> left;
        Node<T> right;
        Node(T obj)
        {
            this.obj = obj;
            left = right = null;
        }
    }

    Node<T> root=null;
    String output;

    public void add(T obj)
    {
        if (!contains(obj))
            root = insertKey(root, obj);
    }

    // Insert key in the tree
    private Node<T> insertKey(Node<T> current, T key)
    {
        // Return a new node if the tree is empty
        if (current == null)
        {
            return new Node<T>(key);
        }
        // Traverse to the right place and insert the node
        if (key.compareTo(current.obj) > 0)
            current.left = insertKey(current.left, key);
        else if (key.compareTo(current.obj) < 0)
            current.right = insertKey(current.right, key);
        else
            return current;
        return current;
    }

    // Inorder Traversal
    Node<T> inorderRec(Node<T> root)
    {
        if (root != null)
        {
            inorderRec(root.left);
            if (!output.equals(""))
                output =output+" "+root.obj;
            else
                output =output+""+root.obj;
            inorderRec(root.right);
        }
        return root;
    }

    public boolean contains(T obj)
    {
        return contain(root,obj);
    }

    public boolean contain(Node<T> temp,T obj)
    {
        if (temp==null) return false;
        if (obj.compareTo(temp.obj)==0 ) return true;
        return (obj.compareTo(temp.obj) < 0)
                    ? contain(temp.right, obj)
                    : contain(temp.left, obj);
    }

    public String toString()
    {
        output="";
        inorderRec(root);
        return output ;

    }
    
    public static void main(String[] args) {
        InvertedSearchTree<Integer> tree = new InvertedSearchTree<Integer>();
        tree.add(4);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(10);
        tree.add(12);
        tree.add(7);
        System.out.println("tree inorder: " + tree.toString());
        InvertedSearchTree<Integer> tree2 = new InvertedSearchTree<Integer>();
        tree2.add(4);
        tree2.add(2);
        System.out.println("tree inorder: " + tree2 .toString());
        InvertedSearchTree<Integer> t = new InvertedSearchTree<Integer>();
        t.add(50);
        t.add(30);
        t.add(20);
        t.add(40);
        t.add(70);
        t.add(60);
        t.add(80);
        System.out.println("tree inorder: " + t .toString());
        InvertedSearchTree<Integer> bt = new InvertedSearchTree<Integer>();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        System.out.println("tree inorder: " + bt .toString());
    }

}
