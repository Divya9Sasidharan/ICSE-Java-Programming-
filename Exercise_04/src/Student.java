import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.out;

public class Student {

    private String name;
    private int id;

    public void setName() {
        this.name="";
    }
    public void setId() {

        this.id=0;
    }
    public int getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public Student(String name,int id){
        this.name=name;
        this.id=id;


    }

    public static void main(String[] args) {
        Student std1 = new Student("divya",2);
        Student std2 = new Student("divya",3);
        Student std3 = new Student("divya",4);
        // Create and initialize a Queue using a LinkedList
        Queue<Student> S = new LinkedList<>();
        S.add(std1);
        S.add(std2);
        S.add(std3);
        System.out.println("WaitingQueue : " + S.element().name + " : " + Integer.toString(S.element().id));
        for (int i = 0; i < S.size(); i++) {
            System.out.println(" ");

            System.out.print(((LinkedList<Student>) S).get(i).name + " : "+((LinkedList<Student>) S).get(i).id);
        }
        System.out.println();

    }


    }




