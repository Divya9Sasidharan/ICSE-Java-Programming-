/*
* Reference :-
* https://www.techiedelight.com/calculate-height-binary-tree-iterative-recursive/
* https://www.techiedelight.com/find-maximum-sum-root-to-leaf-path-binary-tree/
* https://stackoverflow.com/questions/63330222/binary-tree-maximum-path-sum-algorithm
* */



import java.util.ArrayDeque;
import java.util.Queue;

public class MyBinaryTree extends BinaryTree<Integer> {
    int sum=0;

    public MyBinaryTree(Integer element) {
        super(element);
    }

    public MyBinaryTree getLeft() {
        return (MyBinaryTree) super.getLeft();
    }

    public MyBinaryTree getRight() {
        return (MyBinaryTree) super.getRight();
    }


    public int height() {
        if (getRoot() == null) {
            return 0;
        }
        Queue<MyBinaryTree> queue = new ArrayDeque<>();
        queue.add((MyBinaryTree) getRoot());
        MyBinaryTree front = null;
        int height = 0;
        while (!queue.isEmpty())
        {
            int size = queue.size();

            while (size-- > 0) {
                front = queue.poll();

                if (front.getLeft() != null) {
                    queue.add(front.getLeft());
                }

                if (front.getRight() != null) {
                    queue.add(front.getRight());
                }
            }
            height++;
        }
        return height;
    }



        public int maxSum() {

        if (getRoot() == null) {
            return 0;
        }
        Queue<MyBinaryTree> queueL = new ArrayDeque<>();
        Queue<MyBinaryTree> queueR = new ArrayDeque<>();
        queueL.add((MyBinaryTree) getRoot().getLeft());
        queueR.add((MyBinaryTree) getRoot().getRight());
        MyBinaryTree rootL = null;
        MyBinaryTree rootR = null;
        int leftSum =0;
        int rightSum =0;
        if (getRoot().getLeft()!=null)
        {
            leftSum += (int) getRoot().getLeft().getElement();
            //System.out.println("first left-- "+leftSum);
        }
        if (getRoot().getRight()!=null)
        {
            rightSum += (int) getRoot().getRight().getElement();
            //System.out.println("first right--- "+rightSum);
        }

        while (!queueL.isEmpty())
        {
            int size1 = queueL.size();
            //System.out.println("size1 L--- "+size1);
            while (size1-- > 0)
            {
                rootL = queueL.poll();
                assert rootL != null;
                if (rootL.getLeft() != null)
                {
                    queueL.add(rootL.getLeft());
                    //System.out.println("next left left--- "+rootL.getLeft().getElement());
                    leftSum += (int) rootL.getLeft().getElement();
                    //System.out.println("leftSum--- "+leftSum);
                }

                if (rootL.getRight() != null)
                {
                    queueL.add(rootL.getRight());
                    //System.out.println("next left right--- "+rootL.getRight().getElement());
                    leftSum += (int) rootL.getRight().getElement();
                    //System.out.println("leftSum--- "+leftSum);
                }
            }
        }
        while (!queueR.isEmpty())
        {
            int size = queueR.size();
            //System.out.println("size R--- "+size);
            while (size-- > 0)
            {
                rootR = queueR.poll();
                assert rootR != null;
                if (rootR.getLeft() != null)
                {
                    queueR.add(rootR.getLeft());
                    //System.out.println("next  right left--- "+rootR.getLeft().getElement());
                    rightSum += (int) rootR.getLeft().getElement();
                    //System.out.println("rightSum--- "+rightSum);
                }
                if (rootR.getRight() != null)
                {
                    queueR.add(rootR.getRight());
                    //System.out.println("next  right right--- "+rootR.getRight().getElement());
                    rightSum += (int) rootR.getRight().getElement();
                    //System.out.println("rightSum--- "+rightSum);
                    }

                    }
        }
        //System.out.println((leftSum) );
        //System.out.println((rightSum));
        return Math.max(leftSum, rightSum);


        }


    public static int pathSum(MyBinaryTree root)
    {
        //System.out.println("root is "+root.getElement());
        if (root == null) {
            return 0;
        }

        int leftPath = pathSum(root.getLeft());
        int rightPath = pathSum(root.getRight());
        //System.out.println(leftPath);
        //System.out.println(rightPath);
        return (leftPath > rightPath ? leftPath : rightPath) + (int)root.getElement();
    }



    public int maxPathSum() {

        return pathSum((MyBinaryTree) getRoot());

    }

    public int maxWidth() {
        if (getRoot() == null) {
            return 0;
        }

        Queue<MyBinaryTree> queueW = new ArrayDeque<>();
        queueW.add((MyBinaryTree) getRoot());
        MyBinaryTree curr = null;
        int max = 0;
        while (!queueW.isEmpty())
        {
            int width = queueW.size();
            if (max < width) {
                max = width;
            }
            while (width-- > 0)
            {
                curr = queueW.poll();
                assert curr != null;
                if (curr.getLeft() != null) {
                    queueW.add(curr.getLeft());
                }
                if (curr.getRight() != null) {
                    queueW.add(curr.getRight());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree(-8);
        tree.addLeft(new MyBinaryTree(4));
        tree.getLeft().addLeft(new MyBinaryTree(6));
        tree.getLeft().addRight(new MyBinaryTree(-11));
        tree.getLeft().getLeft().addLeft(new MyBinaryTree(10));
        //System.out.println(tree.getElement());
        //System.out.println(tree.getLeft().getElement());
        //System.out.println(tree.getLeft().getLeft().getElement());
        //System.out.println(tree.getLeft().getRight().getElement());
        //System.out.println(tree.getLeft().getLeft().getLeft().getElement());

        tree.addRight(new MyBinaryTree(1));
        tree.getRight().addLeft(new MyBinaryTree(5));
        tree.getRight().addRight(new MyBinaryTree(7));
        //System.out.println(tree.getElement());
        //System.out.println(tree.getRight().getElement());
        //System.out.println(tree.getRight().getLeft().getElement());
        //System.out.println(tree.getRight().getRight().getElement());
        System.out.println("The height of the binary tree is " + tree.height());
        System.out.println("Max Sum = "+ tree.maxSum());
        System.out.println("Max Path Sum = "+ tree.maxPathSum());
        System.out.println("Max Width  = "+ tree.maxWidth());
        tree = new MyBinaryTree(1);
        tree.addLeft(new MyBinaryTree(2));
        tree.addRight(new MyBinaryTree(3));
        tree.getLeft().addLeft(new MyBinaryTree(8));
        tree.getLeft().addRight(new MyBinaryTree(4));
        tree.getRight().addLeft(new MyBinaryTree(5));
        tree.getRight().addRight(new MyBinaryTree(6));
        tree.getLeft().getLeft().addLeft(new MyBinaryTree(10));
        tree.getLeft().getRight().addLeft(new MyBinaryTree(10));
        tree.getRight().getLeft().addLeft(new MyBinaryTree(7));
        tree.getRight().getLeft().addRight(new MyBinaryTree(9));
        tree.getRight().getRight().addRight(new MyBinaryTree(11));
        tree.getRight().getRight().addLeft(new MyBinaryTree(12));
        System.out.println("The height of the binary tree is " + tree.height());
        System.out.println("Max Sum = "+ tree.maxSum());
        System.out.println("Max Path Sum = "+ tree.maxPathSum());
        System.out.println("Max Width  = "+ tree.maxWidth());




    }

}
