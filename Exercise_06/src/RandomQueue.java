/*
* reference:- http://www.java2s.com/example/java/data-structure/randomized-queue.html
* */
@SuppressWarnings("unchecked")
public class RandomQueue<T> implements Queue<T> {
    T[] items;
    int N;
    int first;
    int last;

    public RandomQueue()
    {

        items = (T[]) new Object[1];
        first= 0;
        last =-1;
        N=0;
    }



    public boolean isEmpty() {
        return (N == 0);
    }

    public boolean isFull() {
        if (N == items.length)
            return true;
        else
            return false;
    }
    // resize array as needed
    private void resize(int newsize) {
        if (newsize < 1)
            return;
        T[] temp = (T[]) new Object[newsize];
        for (int i = 0; i < N; i++) {
            temp[i] = items[i];
            items[i] = null;
        }
        items = temp;
    }

    public void enqueue(T item) {
        if (!isFull())
        {
            last=(last+1)%items.length;
            items[last]=item;
            N++;
        }
        else {
            resize(items.length * 2);
            last=(last+1)%items.length;
            items[last]=item;
            N++;

        }
    }

    public T dequeue() {
        if (isEmpty())
            return null;
        T removed= items[first];
        items[first]=null;
        first=(first+1)%items.length;
        N--;
        return removed;

    }

    @Override
    public T front() {
        if (isEmpty())
            return null;
        else
            return items[first];
    }


    @Override
    public int size() {
        return N;
    }

    public T sample() {
        if (isEmpty())
            return null;
        T removed= items[first];
        items[first]=null;
        first=(first+1)%items.length;
        N--;
        return removed;
    }

    public static void main(String[] args) {
        RandomQueue<Integer> randqueue = new RandomQueue<Integer>();
        int N =10;
        // testing enqueue-dequeue
        System.out.println("********** Testing Enqueue-Dequeue **********");



    }

}
