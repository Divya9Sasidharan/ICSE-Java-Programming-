public class LinkedNode<T> {
  T data_ = null;
  LinkedNode<T> next_ = null;


  //A value constructor that initializes the value of the node with the object received in input and the pointer to null;
  public LinkedNode(T data_)
  {
    this.data_=data_;
    this.next_=null;

  }

  //Getter and setter methods to manipulate the node.
  public LinkedNode<T> getNext_(){
    return next_;
  }
  public void setNext_(LinkedNode<T> next_){
    this.next_=next_;
  }

  // Provide String-representation for list beginning at `this` node.
  @Override
  public String toString() {
    {
      String out = "";
      LinkedNode<T> next_ = this;
      while(next_!=null) {
        out =out + next_.data_+", ";
        next_ = next_.getNext_();
      }
      return out.substring(0, out.length()-2);// remove last , before returning the result
    }
  }

  public static void main(String[] args) {
    LinkedNode<String> my_day = new LinkedNode<String>("sleeping late");
    my_day.setNext_(new LinkedNode<String>("attending party"));
    my_day.getNext_().setNext_(new LinkedNode<String>("going to bed"));
    System.out.println(my_day.toString());

    LinkedNode<String>  my_day2 = my_day.getNext_();
    //System.out.println(my_day2.toString());
    my_day.setNext_(new LinkedNode<String>("go to mensa"));
    my_day.getNext_().setNext_(new LinkedNode<String>("attend face-to-face lecture"));
    my_day.getNext_().getNext_().setNext_(new LinkedNode<String>("return library book"));
    my_day.getNext_().getNext_().getNext_().setNext_(new LinkedNode<String>("take tram "));
    my_day.getNext_().getNext_().getNext_().getNext_().setNext_(my_day2);
    System.out.println(my_day.toString());

    LinkedNode<String> week = new LinkedNode<String>("Monday");
    week.setNext_(new LinkedNode<String>("Thursday"));
    week.getNext_().setNext_(new LinkedNode<String>("Friday"));
    System.out.println(week.toString());

    LinkedNode<String>  week2 = week.getNext_();
    //System.out.println(week2.toString());
    week.setNext_(new LinkedNode<String>("Tuesday"));
    week.getNext_().setNext_(new LinkedNode<String>("Wednesday"));
    week.getNext_().getNext_().setNext_(week2);
    System.out.println(week.toString());









  }
}
