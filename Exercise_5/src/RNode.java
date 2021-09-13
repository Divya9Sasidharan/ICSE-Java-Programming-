

public class RNode {
    int data = Integer.MAX_VALUE;
    RNode prev =null;
    RNode next =null;


    public RNode()
    {}

    public RNode(int n,RNode next)
    {
        data=n;
        next=next;

    }
    public RNode getNext()
    {
        return next;
    }
    public void setNext(RNode next){
        this.next=next;
    }
    public RNode getPrev()
    {
        return prev;
    }
    public void setPrev(RNode next){
        this.prev=prev;
    }



    public void insert_before(int n, RNode position)

    {
        RNode newNode = new RNode(n,position);
        next=prev;



    }
    public RNode find(int x){
        {

            RNode next = this;
            while(next!=null) {
                if (x == next.data)
                {
                    return next;
                }
                next=next.getNext();

            }
            return null;
        }
    }

}

